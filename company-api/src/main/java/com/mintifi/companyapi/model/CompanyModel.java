package com.mintifi.companyapi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.time.LocalDateTime;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@JsonIgnoreProperties(ignoreUnknown = true,value = "dateOfInc")
public class CompanyModel {
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

  private Attribute[] attributes;

}


