package com.mintifi.companyapi.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "company_gstin")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CompanyGstin {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  private long companyId;
  private String gstin;

}
