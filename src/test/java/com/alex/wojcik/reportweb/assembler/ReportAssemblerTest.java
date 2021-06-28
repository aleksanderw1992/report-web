package com.alex.wojcik.reportweb.assembler;

import com.alex.wojcik.reportweb.dto.ReportItemDto;
import com.alex.wojcik.reportweb.entity.ReportItem;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.stream.Stream;
import org.junit.Assert;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
class ReportAssemblerTest {

  private ReportAssembler objectUnderTests =  new ReportAssembler();


  @ParameterizedTest
  @MethodSource("provideDataForTest")
  void testFromDto(String id, LocalDateTime startDate, LocalDateTime endDate, String description) {
    ReportItemDto dto = new ReportItemDto();
    dto.setId(id);
    dto.setStartDate(startDate);
    dto.setEndDate(endDate);
    dto.setDescription(description);

    ReportItem entity = objectUnderTests.fromDto(dto);
    Assert.assertEquals(id, entity.getId());
    Assert.assertEquals(startDate, entity.getStartDate());
    Assert.assertEquals(endDate, entity.getEndDate());
    Assert.assertEquals(description, entity.getDescription());
  }

  @ParameterizedTest
  @MethodSource("provideDataForTest")
  void testToDto(String id, LocalDateTime startDate, LocalDateTime endDate, String description, String expectedDescription) {
    ReportItem entity = new ReportItem();
    entity.setId(id);
    entity.setStartDate(startDate);
    entity.setEndDate(endDate);
    entity.setDescription(description);

    ReportItemDto dto = objectUnderTests.toDto(entity);
    Assert.assertEquals(id, dto.getId());
    Assert.assertEquals(startDate, dto.getStartDate());
    Assert.assertEquals(endDate, dto.getEndDate());
    Assert.assertEquals(expectedDescription, dto.getDescription());
  }

  private static Stream<Arguments> provideDataForTest() {
    return Stream.of(
        Arguments.of("INT-0001", LocalDateTime.of(LocalDate.now(), LocalTime.NOON), LocalDateTime.of(LocalDate.now(), LocalTime.NOON.plusHours(1)), null, ""),
        Arguments.of("INT-0002", LocalDateTime.of(LocalDate.now(), LocalTime.NOON.minusMinutes(10)), LocalDateTime.of(LocalDate.now(), LocalTime.NOON.plusHours(2)), "Description", "Description"),
        Arguments.of("INT-0003", LocalDateTime.of(LocalDate.now(), LocalTime.NOON), LocalDateTime.of(LocalDate.now(), LocalTime.NOON.plusHours(10)), "Asdf", "Asdf")
    );
  }


}