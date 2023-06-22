package com.mintifi.companyapi.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mintifi.companyapi.entity.CompanyAttributes;
import com.mintifi.companyapi.repository.AttributeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyAttributeService {

  @Autowired
  private AttributeRepository attributeRepository;
  @Autowired
  private ObjectMapper objectMapper;

  public CompanyAttributes addCompanyAttribute(String attribute){
    CompanyAttributes companyAttributes = null;
    try {
      companyAttributes = objectMapper.readValue(attribute,
          CompanyAttributes.class);
    } catch (JsonProcessingException e) {
      e.getMessage();
    }
    CompanyAttributes save = attributeRepository.save(companyAttributes);
    return save;

  }



}
