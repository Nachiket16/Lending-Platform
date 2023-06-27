package com.mintifi.companyapi.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mintifi.companyapi.entity.Industry;
import com.mintifi.companyapi.repository.IndustryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class IndustryService {
    @Autowired
    private IndustryRepository industryRepository;

    private ObjectMapper objectMapper;

    public Industry addIndustry(String industryModel){
        Industry industry;

        try {
            industry = objectMapper.readValue(industryModel, Industry.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        Industry save = industryRepository.save(industry);
        return save;
    }
}

