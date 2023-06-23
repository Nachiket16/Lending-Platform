package com.mintifi.companyapi.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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
    Map<String,String> customAttribute = new LinkedHashMap<>();
    Company company = companyRepository.findById(companyId)
        .orElseThrow(()->new ResourceNotFoundException(companyId));
    JSONObject jsonObject = new JSONObject(companyModelString);

    for (String key : jsonObject.keySet()) {
      if (key.endsWith("__c")) {
        String value = jsonObject.get(key).toString();
        attributeRepository.findByApiName(key).orElseThrow(()->new ResourceNotFoundException(key));
        customAttribute.put(key,value);
        System.out.println("Key: " + key + ", Value: " + value);
      }
    }
    return null;

  }

}
