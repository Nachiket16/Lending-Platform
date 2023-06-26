package com.mintifi.companyapi.entity;

import jakarta.persistence.Column;
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
  private String apiName;
  @Column(name = "`group`")
  private String group;
  private String type;
  private String regex;
  private String error;
  private boolean disabled;
  private boolean required;

}
