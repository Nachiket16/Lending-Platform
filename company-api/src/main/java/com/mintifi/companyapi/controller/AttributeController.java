package com.mintifi.companyapi.controller;

import com.mintifi.companyapi.entity.CompanyAttributes;
import com.mintifi.companyapi.service.CompanyAttributeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/attribute")
public class AttributeController {

  @Autowired
  private CompanyAttributeService companyAttributeService;

  @PostMapping("/add")
  public ResponseEntity<CompanyAttributes> addAttribute(@RequestBody String attribute){
    CompanyAttributes companyAttributes = companyAttributeService.addCompanyAttribute(attribute);
    return ResponseEntity.ok(companyAttributes);
  }

}
