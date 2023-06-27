package com.mintifi.companyapi.controller;

import com.mintifi.companyapi.entity.Industry;
import com.mintifi.companyapi.service.IndustryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/industry")
public class IndustryController {
    @Autowired
    private IndustryService industryService;

    @PostMapping("/add")
    public ResponseEntity<Industry> createIndustry(@RequestBody String payload){
        Industry industry = industryService.addIndustry(payload);
        return ResponseEntity.ok(industry);
    }
}
