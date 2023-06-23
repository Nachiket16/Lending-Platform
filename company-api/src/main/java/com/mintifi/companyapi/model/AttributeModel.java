package com.mintifi.companyapi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotEmpty;
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
@JsonIgnoreProperties(ignoreUnknown = true)
public class AttributeModel {
  
  @JsonProperty("label")
  private String label;
  
  @JsonProperty("apiName")
  private String apiName;
  
  @JsonProperty("group")
  private String group;
  
  @JsonProperty("type")
  private String type;
  
  @JsonProperty("disabled")
  private boolean disabled;
  
  @JsonProperty("required")
  private boolean required;
  
  @JsonProperty("regex")
  private String regex;
  
  @JsonProperty("value")
  private String value;
  
  @JsonProperty("error")
  private String error;

}
