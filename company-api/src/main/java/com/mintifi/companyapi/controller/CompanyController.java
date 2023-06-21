package com.mintifi.companyapi.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/company")
public class CompanyController {
// Rest API -> CRUD OPS

  @PostMapping("/add")
  public ResponseEntity<String> createCompany(@RequestBody String payload){
    return null;
  }


}
