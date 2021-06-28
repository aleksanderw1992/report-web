package com.alex.wojcik.reportweb.util;

import com.alex.wojcik.reportweb.entity.ReportItem;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public final class TestsUtils {
  public static final String DEFAULT_ID = "ID";

  private TestsUtils() {
    throw new UnsupportedOperationException();
  }

  public static ReportItem createEntity(LocalDateTime startDate, LocalDateTime endDate) {
    ReportItem entity = new ReportItem();
    entity.setId(DEFAULT_ID);
    entity.setStartDate(startDate);
    entity.setEndDate(endDate);
    return entity;
  }

  public static ReportItem createDefaultEntity() {
    final LocalDateTime defaultLocalDateTime = LocalDateTime.of(LocalDate.now(), LocalTime.NOON);
    return createEntity(defaultLocalDateTime, defaultLocalDateTime);
  }
}
