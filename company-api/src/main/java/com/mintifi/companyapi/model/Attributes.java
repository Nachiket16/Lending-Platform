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
public class Attributes {
  
  @NotEmpty
  @JsonProperty("label")
  private String label;
  
  @NotEmpty
  @JsonProperty("apiName")
  private String apiName;
  
  @NotEmpty
  @JsonProperty("group")
  private String group;
  
  @NotEmpty
  @JsonProperty("type")
  private String type;
  
  @NotEmpty
  @JsonProperty("disabled")
  private boolean disabled;
  
  @NotEmpty
  @JsonProperty("required")
  private boolean required;
  
  @NotEmpty
  @JsonProperty("regex")
  private String regex;
  
  @NotEmpty
  @JsonProperty("value")
  private String value;
  
  @NotEmpty
  @JsonProperty("error")
  private String error;

}
