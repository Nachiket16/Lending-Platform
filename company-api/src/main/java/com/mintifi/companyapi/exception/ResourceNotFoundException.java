package com.mintifi.companyapi.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResourceNotFoundException extends RuntimeException {

  String resourceName;
  String fieldName;
  long fieldValue;

  String fieldMessage;

  public ResourceNotFoundException(String resourceName, String fieldName, long fieldValue) {
    super(String.format("%s not found with %s : %s", resourceName, fieldName, fieldValue));
    this.resourceName = resourceName;
    this.fieldName = fieldName;
    this.fieldValue = fieldValue;
  }

  public ResourceNotFoundException(String resourceName, String fieldName, String fieldMessage) {
    super(String.format("%s not found with %s : %s", resourceName, fieldName, fieldMessage));
    this.resourceName = resourceName;
    this.fieldName = fieldName;
    this.fieldMessage = fieldMessage;
  }

  public ResourceNotFoundException(String fieldName) {
    super(String.format("not found with %s ", fieldName));
    this.fieldName = fieldName;
  }

  public ResourceNotFoundException(long fieldValue) {
    super(String.format("not found with id %s ", fieldValue));
    this.fieldValue = fieldValue;
  }

}
