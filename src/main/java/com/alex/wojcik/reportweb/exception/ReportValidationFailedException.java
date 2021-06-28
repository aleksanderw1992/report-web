package com.alex.wojcik.reportweb.exception;

public class ReportValidationFailedException extends RuntimeException {

  public ReportValidationFailedException(String message) {
    super(message);
  }
}
