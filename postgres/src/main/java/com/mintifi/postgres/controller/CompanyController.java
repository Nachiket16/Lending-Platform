package com.mintifi.postgres.controller;

import com.mintifi.postgres.entity.Company;
import com.mintifi.postgres.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
public class CompanyController {
  @Autowired
  private CompanyService companyService;

  @GetMapping()
  public String hello(){
    return "Hello";
  }

  @PostMapping("/company")
  public ResponseEntity<Company> addCompany(@RequestBody String companyPayload){
    Company company = companyService.addCompany(companyPayload);
    return ResponseEntity.ok(company);
  }

}
