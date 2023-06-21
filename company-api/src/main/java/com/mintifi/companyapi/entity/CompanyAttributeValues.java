package com.mintifi.companyapi.entity;

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
public class CompanyAttributeValues {
  //company value with attribute details like-> regex, required, type

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

}
