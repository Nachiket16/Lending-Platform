package com.mintifi.companyapi.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.mintifi.companyapi.entity.Company;
import com.mintifi.companyapi.entity.CompanyAttributeValues;
import com.mintifi.companyapi.entity.CompanyAttributes;
import com.mintifi.companyapi.exception.ResourceNotFoundException;
import com.mintifi.companyapi.model.Attributes;
import com.mintifi.companyapi.model.CompanyModel;
import com.mintifi.companyapi.repository.AttributeRepository;
import com.mintifi.companyapi.repository.CompanyRepository;
import com.mintifi.companyapi.repository.ValueRepository;
import jakarta.persistence.Transient;
import jakarta.persistence.Tuple;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyService {

  @Autowired
  private CompanyRepository companyRepository;

  @Autowired
  private ModelMapper modelMapper;

  @Autowired
  private ObjectMapper objectMapper;

  @Autowired
  private AttributeRepository attributeRepository;

  @Autowired
  private ValueRepository valueRepository;

  public List<Company> getAllCompany(){
    List<Company> all = companyRepository.findAll();
    return all;
  }

  public Company addCompany(String companyPayload){
    Company company;
    try {
      company =objectMapper.readValue(companyPayload, Company.class);
    } catch (JsonProcessingException e) {
      throw new RuntimeException(e);
    }
    Company save = companyRepository.save(company);
    return save;
  }
  @Transient
  public CompanyModel addCompanyModel(String companyModelString){
    modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
    CompanyModel companyModel;
    try {
      companyModel =objectMapper.readValue(companyModelString, CompanyModel.class);
    } catch (JsonProcessingException e) {
      throw new RuntimeException(e);
    }
    System.out.println("companyModel = " + companyModel);

    Company company = modelMapper.map(companyModel, Company.class);
    Company savedCompany = companyRepository.save(company);
    Attributes[] attributes = companyModel.getAttributes();

    List<CompanyAttributes> attributesList = new ArrayList<>();

    for (Attributes attribute :attributes){
      CompanyAttributeValues companyAttributeValues = new CompanyAttributeValues();
      CompanyAttributes companyAttribute = modelMapper.map(attribute, CompanyAttributes.class);
      attributesList.add(companyAttribute);
        CompanyAttributes saveCompanyAttribute = attributeRepository.save(companyAttribute);
      System.out.println("saveCompanyAttribute = " + saveCompanyAttribute);

      companyAttributeValues.setCompanyId(savedCompany.getId());
      companyAttributeValues.setCompanyAttributeId(saveCompanyAttribute.getId());
      companyAttributeValues.setType(attribute.getType());
      companyAttributeValues.setRegex(attribute.getRegex());
      companyAttributeValues.setAttributeValue(attribute.getValue());

      CompanyAttributeValues savedCompanyAttrValue = valueRepository.save(companyAttributeValues);
      System.out.println("savedCompanyAttrValue = " + savedCompanyAttrValue);

    }

    return companyModel;
  }

  @Transient
  public Company addCustomCompany(long companyId ,String companyModelString) {
    modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
    List<CompanyAttributes> companyAttributesList = null;
    Company company = companyRepository.findById(companyId)
        .orElseThrow(()->new ResourceNotFoundException(companyId));
    JSONObject jsonObject = new JSONObject(companyModelString);

    for (String key : jsonObject.keySet()) {
      if (key.endsWith("__c")) {
        CompanyAttributeValues companyAttributeValues = new CompanyAttributeValues();
        String value = jsonObject.get(key).toString();
        CompanyAttributes companyAttributes = attributeRepository.findByApiName(key)
            .orElseThrow(() -> new ResourceNotFoundException(key));
        companyAttributeValues.setCompanyId(company.getId());
        companyAttributeValues.setCompanyAttributeId(companyAttributes.getId());
        companyAttributeValues.setRegex(companyAttributes.getRegex());
        companyAttributeValues.setType(companyAttributes.getType());
        companyAttributeValues.setGroup(companyAttributes.getGroup());
        companyAttributeValues.setError(companyAttributes.getError());
        companyAttributeValues.setAttributeValue(value);
        CompanyAttributeValues entityCompanyAttributeValue = valueRepository.save(companyAttributeValues);
      }
    }
    CompanyModel companyModel;
    try {
      companyModel =objectMapper.readValue(companyModelString, CompanyModel.class);
    } catch (JsonProcessingException e) {
      throw new RuntimeException(e);
    }

    Company updatedCompany = modelMapper.map(companyModel, Company.class);
    updatedCompany.setId(company.getId());
    Company updatedEntity = companyRepository.save(updatedCompany);
    return updatedEntity;
  }

  public String getCompanyAttributeValue(Long id){
    Company company = companyRepository.findById(id)
        .orElseThrow(()->new ResourceNotFoundException(id));
    List<Tuple> companyAttributeWithValue = companyRepository.getCompanyAttributeWithValue(id);
    String stringJson = convert(companyAttributeWithValue);
    return stringJson;
  }

  public String convert(List<Tuple> tupleList) {
    ObjectMapper objectMapper = new ObjectMapper();
    JsonNodeFactory nodeFactory = objectMapper.getNodeFactory();
    ObjectNode mainJson = nodeFactory.objectNode();
    for (Tuple tuple : tupleList) {
      // Extract common columns
      Long id = tuple.get("id", Long.class);
      String name = tuple.get("name", String.class);
      String type = tuple.get("type", String.class);
      String bizEmail = tuple.get("biz_email", String.class);
      String mobileNumber = tuple.get("mobile_number", String.class);
      String bizPan = tuple.get("biz_pan", String.class);
      String bizCin = tuple.get("biz_cin", String.class);
      String bizTin = tuple.get("biz_tin", String.class);
      String noOfDirectors = tuple.get("no_of_directors", String.class);
      String udyamCertNo = tuple.get("udyam_cert_no", String.class);
      String brandLogoUrl = tuple.get("brand_logo_url", String.class);
      long industryId = tuple.get("industry_id", Long.class);
      long parentId = tuple.get("parent_id", Long.class);

      // Add common columns to the main JsonObject
      mainJson.put("id", id);
      mainJson.put("name", name);
      mainJson.put("type", type);
      mainJson.put("bizEmail", bizEmail);
      mainJson.put("mobileNumber", mobileNumber);
      mainJson.put("bizPan", bizPan);
      mainJson.put("bizCin", bizCin);
      mainJson.put("bizTin", bizTin);
      mainJson.put("noOfDirectors", noOfDirectors);
      mainJson.put("udyamCertNo", udyamCertNo);
      mainJson.put("industryId", industryId);
      mainJson.put("brandLogoUrl", brandLogoUrl);
      mainJson.put("parentId  ", parentId);
      // Add different columns JsonObject as a nested object
      mainJson.put(tuple.get("api_name", String.class), tuple.get("attribute_value",
          String.class));
    }
    try {
      return objectMapper.writeValueAsString(mainJson);
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }
}
