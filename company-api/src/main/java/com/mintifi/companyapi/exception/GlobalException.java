package com.mintifi.companyapi.exception;


import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class GlobalException extends RuntimeException {
  final HttpStatus status;

  public GlobalException(String message, HttpStatus status) {
    super(message);
    this.status = status;
  }
}
