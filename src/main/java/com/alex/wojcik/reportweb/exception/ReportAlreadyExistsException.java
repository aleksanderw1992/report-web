package com.alex.wojcik.reportweb.exception;

public class ReportAlreadyExistsException extends RuntimeException {

  private String id;

  public ReportAlreadyExistsException(String id) {
    super(String.format("Report with id %s already exists", id));
    this.id = id;
  }

  public String getId() {
    return id;
  }
}
