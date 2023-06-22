package com.mintifi.companyapi.repository;

import com.mintifi.companyapi.entity.CompanyAttributes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttributeRepository extends JpaRepository<CompanyAttributes, Long> {

}
