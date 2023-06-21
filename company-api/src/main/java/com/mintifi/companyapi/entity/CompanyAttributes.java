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
@Table(name = "company_attributes")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompanyAttributes {
  //company attributes with the regex,type,required
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  private String label;
  private String appName;
  private String type;
  private String regex;
  private boolean disabled;
  private boolean required;

  //Future scope
//  private long groupId;

}
