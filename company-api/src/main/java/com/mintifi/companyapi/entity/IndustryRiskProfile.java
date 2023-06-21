package com.mintifi.companyapi.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "industry_risk_profile")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class IndustryRiskProfile {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  @Column(name = "industry_id")
  private long industryId;
  @Column(name = "risk_score")
  private String riskScore;
  @Column(name = "risk_status")
  private String riskStatus;

}
