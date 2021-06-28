package com.alex.wojcik.reportweb.service;

import com.alex.wojcik.reportweb.entity.ReportItem;
import com.alex.wojcik.reportweb.exception.ReportValidationFailedException;
import org.springframework.stereotype.Component;

@Component
class RepositoryValidator {

  void validate(ReportItem newEntity) {
    if (newEntity.getStartDate().compareTo(newEntity.getEndDate()) > 0) {
      throw new ReportValidationFailedException("StartDate cannot be greater than EndDate");
    }
  }
}
