package com.mintifi.companyapi.controller;

import com.mintifi.companyapi.model.CompanyModel;
import com.mintifi.companyapi.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/company-model/")
public class CompanyModelController {
  @Autowired
  private CompanyService companyService;

  @PostMapping("/add")
  public ResponseEntity<CompanyModel> createCompany(@Validated @RequestBody String payload){
    CompanyModel company = companyService.addCompanyModel(payload);
    return ResponseEntity.ok(company);
  }


}
