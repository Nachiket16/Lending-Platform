package com.mintifi.companyapi.repository;

import com.mintifi.companyapi.entity.Company;
import jakarta.persistence.Tuple;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {

  @Query(
      value =
          "SELECT comp.*, attr.api_name, attrVal.attribute_value "
              + "FROM company as comp "
              + "LEFT JOIN company_attribute_value as attrVal ON comp.id = attrVal.company_id "
              + "LEFT JOIN company_attributes as attr ON attr.id = attrVal.company_attribute_id "
              + "where comp.id = "
              + ":id",
      nativeQuery = true)
  List<Tuple> getCompanyAttributeWithValue(@Param("id") Long id);

}
