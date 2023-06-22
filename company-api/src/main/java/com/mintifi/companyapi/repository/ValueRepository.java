package com.mintifi.companyapi.repository;

import com.mintifi.companyapi.entity.CompanyAttributeValues;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ValueRepository extends JpaRepository<CompanyAttributeValues, Long> {

}
