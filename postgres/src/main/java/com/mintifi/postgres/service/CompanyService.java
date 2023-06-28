package com.mintifi.postgres.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mintifi.postgres.entity.Company;
import com.mintifi.postgres.mapper.CompanyMapper;
import com.mintifi.postgres.model.CompanyModel;
import com.mintifi.postgres.repository.CompanyRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CompanyService {
  @Autowired
  private ModelMapper modelMapper;
  @Autowired
  private ObjectMapper objectMapper;
  @Autowired
  private CompanyRepository companyRepository;

  private CompanyMapper companyMapper;

  public Company addCompany(String companyPayload) {
    CompanyModel companyModel = null;
    try {
      companyModel = objectMapper.readValue(companyPayload, CompanyModel.class);
    } catch (JsonProcessingException e) {
      throw new RuntimeException(e);
    }
    Company company = new Company();
    Company company1 = companyMapper.updateEntityFromModel(companyModel, company);
    Company save = companyRepository.save(company1);

    return save;
  }
}
