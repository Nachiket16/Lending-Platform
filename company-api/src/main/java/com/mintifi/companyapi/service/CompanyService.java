package com.mintifi.companyapi.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mintifi.companyapi.entity.Company;
import com.mintifi.companyapi.repository.CompanyRepository;
import java.util.List;
import org.modelmapper.ModelMapper;
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

  public Company addCompany(String companyModel){
    Company company;
//    = modelMapper.map(companyModel, Company.class);
    try {
      company =objectMapper.readValue(companyModel, Company.class);
    } catch (JsonProcessingException e) {
      throw new RuntimeException(e);
    }
    Company save = companyRepository.save(company);
    return save;
  }

  public List<Company> getAllCompany(){
    List<Company> all = companyRepository.findAll();
    return all;
  }



}
