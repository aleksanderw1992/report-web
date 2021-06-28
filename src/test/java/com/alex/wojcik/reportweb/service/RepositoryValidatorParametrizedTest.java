package com.alex.wojcik.reportweb.service;

import static org.junit.Assert.assertThrows;

import com.alex.wojcik.reportweb.entity.ReportItem;
import com.alex.wojcik.reportweb.exception.ReportValidationFailedException;
import com.alex.wojcik.reportweb.util.TestsUtils;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
class RepositoryValidatorParametrizedTest {

  private RepositoryValidator objectUnderTests = new RepositoryValidator();

  @ParameterizedTest
  @MethodSource("provideDataForTestShouldSucceed")
  void testValidateShouldSucceed(LocalDateTime startDate, LocalDateTime endDate) {
    ReportItem entity = TestsUtils.createEntity(startDate, endDate);
    objectUnderTests.validate(entity);
  }


  @ParameterizedTest
  @MethodSource("provideDataForTestShouldFail")
  void testValidateShouldFail(LocalDateTime startDate, LocalDateTime endDate) {
    assertThrows(ReportValidationFailedException.class, () -> {
      ReportItem entity = TestsUtils.createEntity(startDate, endDate);
      objectUnderTests.validate(entity);
    });
  }


  private static Stream<Arguments> provideDataForTestShouldSucceed() {
    return Stream.of(
        Arguments.of(LocalDateTime.of(LocalDate.now(), LocalTime.NOON), LocalDateTime.of(LocalDate.now(), LocalTime.NOON)),
        Arguments.of(LocalDateTime.of(LocalDate.now(), LocalTime.NOON), LocalDateTime.of(LocalDate.now(), LocalTime.NOON.plusHours(1))),
        Arguments.of(LocalDateTime.of(LocalDate.now().minusDays(1), LocalTime.NOON.minusMinutes(10)), LocalDateTime.of(LocalDate.now(), LocalTime.NOON)),
        Arguments.of(LocalDateTime.of(LocalDate.now(), LocalTime.NOON), LocalDateTime.of(LocalDate.now(), LocalTime.NOON.plusHours(10)))
    );
  }

  private static Stream<Arguments> provideDataForTestShouldFail() {
    return Stream.of(
        Arguments.of(LocalDateTime.of(LocalDate.now().plusDays(1), LocalTime.NOON), LocalDateTime.of(LocalDate.now(), LocalTime.NOON)),
        Arguments.of(LocalDateTime.of(LocalDate.now(), LocalTime.NOON.plusHours(1)), LocalDateTime.of(LocalDate.now(), LocalTime.NOON)),
        Arguments.of(LocalDateTime.of(LocalDate.now(), LocalTime.NOON), LocalDateTime.of(LocalDate.now(), LocalTime.NOON.minusMinutes(1))),
        Arguments.of(LocalDateTime.of(LocalDate.now(), LocalTime.NOON), LocalDateTime.of(LocalDate.now(), LocalTime.NOON.minusHours(10)))
    );
  }
}