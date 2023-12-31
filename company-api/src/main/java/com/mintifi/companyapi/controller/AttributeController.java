package com.mintifi.companyapi.controller;

import com.mintifi.companyapi.entity.CompanyAttributes;
import com.mintifi.companyapi.service.CompanyAttributeService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
public class AttributeController {
  @Autowired
  private CompanyAttributeService companyAttributeService;

  @PostMapping("/attribute")
  public ResponseEntity<List<CompanyAttributes>> addAttribute(@RequestBody String attribute){
    List<CompanyAttributes> companyAttributes = companyAttributeService.addCompanyAttribute(attribute);
    return ResponseEntity.ok(companyAttributes);
  }
  @GetMapping("/attributes")
  public ResponseEntity<List<CompanyAttributes>> getAllAttribute(){
    List<CompanyAttributes> companyAttributes = companyAttributeService.getAllCompanyAttribute();
    return ResponseEntity.ok(companyAttributes);
  }

}
