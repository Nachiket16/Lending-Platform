package com.mintifi.companyapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "company")
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true,value = "dateOfInc")
public class Company {
  //company details, Core field will be added her
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  private String name;
  private String type;
  private String bizEmail;
  private String mobileNumber;
  private LocalDateTime dateOfInc;
  private String bizPan;
  private String bizCin;
  private String bizTin;
  private String noOfDirectors;
  private String udyamCertNo;
  private long industryId;
  private String brandLogoUrl;
  private long parentId;



}
