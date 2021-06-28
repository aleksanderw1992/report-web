package com.alex.wojcik.reportweb.service;

import static org.junit.Assert.assertThrows;

import com.alex.wojcik.reportweb.entity.ReportItem;
import com.alex.wojcik.reportweb.exception.ReportValidationFailedException;
import com.alex.wojcik.reportweb.util.TestsUtils;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import org.junit.Test;

public class RepositoryValidatorTest {

  private RepositoryValidator objectUnderTests = new RepositoryValidator();

  @Test
  public void testValidateShouldFailOnMissingRequiredFields() {
    final LocalDateTime defaultLocalDateTime = LocalDateTime.of(LocalDate.now(), LocalTime.NOON);
    assertThrows(ReportValidationFailedException.class, () -> {
      ReportItem entity = TestsUtils.createEntity(defaultLocalDateTime, null);
      objectUnderTests.validate(entity);
    });
    assertThrows(ReportValidationFailedException.class, () -> {
      ReportItem entity = TestsUtils.createEntity(null, defaultLocalDateTime);
      objectUnderTests.validate(entity);
    });
    assertThrows(ReportValidationFailedException.class, () -> {
      ReportItem entity = new ReportItem();
      entity.setStartDate(defaultLocalDateTime);
      entity.setEndDate(defaultLocalDateTime);
      objectUnderTests.validate(entity);
    });
    assertThrows(ReportValidationFailedException.class, () -> {
      ReportItem entity = new ReportItem();
      objectUnderTests.validate(entity);
    });
  }


}