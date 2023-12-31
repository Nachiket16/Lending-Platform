package com.mintifi.companyapi.controller;

import com.mintifi.companyapi.entity.Company;
import com.mintifi.companyapi.service.CompanyService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/company")
public class CompanyController {
// Rest API -> CRUD OPS

  @Autowired
  private CompanyService companyService;

  @PostMapping()
  public ResponseEntity<String> addCompany(@RequestBody String payload) {
    String company = companyService.addCompany(payload);
    return ResponseEntity.ok(company);
  }

  @PutMapping("/{companyId}")
  public ResponseEntity<String> addCompanyWithCustomAttribute(@PathVariable("companyId") long id,
      @RequestBody String payload) {
    String company = companyService.addCustomCompany(id, payload);
    return ResponseEntity.ok(company);
  }

  @GetMapping("/{companyId}")
  public ResponseEntity<String> getCompanyWithCustomAttribute(@PathVariable("companyId") long id) {
    String company = companyService.getCompanyAttributeValue(id);
    return ResponseEntity.ok(company);
  }

  @GetMapping("/getAll")
  public ResponseEntity<List<Company>> getAllCompany() {
    List<Company> allCompany = companyService.getAllCompany();
    return ResponseEntity.ok(allCompany);
  }


}
