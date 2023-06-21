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
@Table(name = "company_risk_profile")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CompanyRiskProfile {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  private long companyId;
  private String riskScore;
  private String riskStatus;


}
