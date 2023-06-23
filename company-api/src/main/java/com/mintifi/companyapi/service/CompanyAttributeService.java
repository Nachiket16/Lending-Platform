package com.mintifi.companyapi.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mintifi.companyapi.entity.CompanyAttributes;
import com.mintifi.companyapi.model.AttributeModel;
import com.mintifi.companyapi.repository.AttributeRepository;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
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
    AttributeModel[] companyAttributesModel = null;
    try {
      companyAttributesModel = objectMapper.readValue(attribute,
          AttributeModel[].class);
    } catch (JsonProcessingException e) {
      e.getMessage();
    }
//    for (AttributeModel attributeModel: companyAttributesModel){
//      CompanyAttributes companyAttributes = new CompanyAttributes();
//      companyAttributes=modelMapper.map(attributeModel, CompanyAttributes.class);
//      CompanyAttributes save = attributeRepository.save(companyAttributes);
//      companyAttributesList.add(save);
//    }
    List<AttributeModel> collect = Arrays.stream(companyAttributesModel)
        .collect(Collectors.toList());
    System.out.println("collect = " + collect);
    return companyAttributesList;
  }


}
