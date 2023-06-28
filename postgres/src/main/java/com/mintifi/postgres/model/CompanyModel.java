package com.mintifi.postgres.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mintifi.postgres.entity.Distributor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CompanyModel {
  private String name;
  private String url;
  private int vintage;
  @JsonProperty("distributor")
  private DistributorModel[] distributorModels;
}
