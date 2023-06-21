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
@Table(name = "anchor_program")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AnchorProgram {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  private long companyId;
  private String securityType;
  private String securityValue;
  private String anchorLimit;
  private String exceededLimit;
  private String subventionType;
  private String subventionPercentageOnRoi;
  private String subventionDays;
  private String onboardingStatus;
  private String subventionPercentageOnPf;
  private String fixedSubventionPercentage;
  private String daysPerAnnum;


}
