package com.mintifi.companyapi.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mintifi.companyapi.entity.CompanyAttributes;
import com.mintifi.companyapi.model.Attributes;
import com.mintifi.companyapi.model.CompanyModel;
import com.mintifi.companyapi.repository.AttributeRepository;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyAttributeService {

  @Autowired
  private AttributeRepository attributeRepository;
  @Autowired
  private ObjectMapper objectMapper;
  @Autowired
  private ModelMapper modelMapper;

  public List<CompanyAttributes> addCompanyAttribute(String attribute) {
    List<CompanyAttributes> companyAttributesList = new ArrayList<>();
    CompanyModel companyModel = new CompanyModel();
    try {
      companyModel = objectMapper.readValue(attribute,
          CompanyModel.class);
    } catch (JsonProcessingException e) {
      e.getMessage();
    }
    Attributes[] attributes = companyModel.getAttributes();
    for (Attributes attributeModel: attributes){
      CompanyAttributes companyAttributes = new CompanyAttributes();
      companyAttributes=modelMapper.map(attributeModel, CompanyAttributes.class);
      CompanyAttributes save = attributeRepository.save(companyAttributes);
      companyAttributesList.add(save);
    }
    return companyAttributesList;
  }


}
