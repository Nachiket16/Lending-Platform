package com.mintifi.companyapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.mintifi.companyapi.config.ValidateAttributeValue;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "company_attribute_value")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ValidateAttributeValue
@JsonIgnoreProperties(ignoreUnknown = true)
public class CompanyAttributeValues {
  //company value with attribute details like-> regex, required, type


  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  private long companyId;
  private long companyAttributeId;
  private String type;
  private String regex;
  private String attributeValue;

}
