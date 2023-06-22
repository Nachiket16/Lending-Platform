package com.mintifi.companyapi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
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
public class Attribute {

  @JsonProperty("label")
  private String label;
  @JsonProperty("appName")
  private String appName;
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

}
