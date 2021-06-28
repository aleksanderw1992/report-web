package com.alex.wojcik.reportweb.service;

import static org.apache.commons.lang3.StringUtils.isBlank;

import com.alex.wojcik.reportweb.entity.ReportItem;
import com.alex.wojcik.reportweb.exception.ReportValidationFailedException;
import java.util.Objects;
import org.springframework.stereotype.Component;

@Component
class RepositoryValidator {

  void validate(ReportItem newEntity) {
    if (isBlank(newEntity.getId()) || Objects.isNull(newEntity.getStartDate()) || Objects.isNull(newEntity.getEndDate())) {
      throw new ReportValidationFailedException("Received incomplete json");
    }
    if (newEntity.getStartDate().compareTo(newEntity.getEndDate()) > 0) {
      throw new ReportValidationFailedException("StartDate cannot be greater than EndDate");
    }
  }
}
