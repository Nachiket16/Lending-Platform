package com.mintifi.companyapi.repository;

import com.mintifi.companyapi.entity.CompanyAttributeValues;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ValueRepository extends JpaRepository<CompanyAttributeValues, Long> {

  @Query(
      value =
          "SELECT * FROM company_attribute_value WHERE company_attribute_id = :attrId AND "
              + "company_id = :compId",
      nativeQuery = true)
  Optional<CompanyAttributeValues> findByCompanyAttributeIdAndCompanyID(@Param("attrId") Long attrId,
   @Param("compId") Long compId);

}
