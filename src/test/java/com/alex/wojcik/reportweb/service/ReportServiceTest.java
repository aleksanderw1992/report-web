package com.alex.wojcik.reportweb.service;

import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import com.alex.wojcik.reportweb.assembler.ReportAssembler;
import com.alex.wojcik.reportweb.dto.ReportItemDto;
import com.alex.wojcik.reportweb.exception.ReportAlreadyExistsException;
import com.alex.wojcik.reportweb.repository.ReportItemRepository;
import com.alex.wojcik.reportweb.util.TestsUtils;
import java.util.Optional;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ReportServiceTest {

  @InjectMocks
  private ReportService objectUnderTests;

  @Mock
  private ReportItemRepository repository;

  @Mock
  private ReportAssembler assembler;

  @Mock
  private RepositoryValidator validator;

  @Before
  public void setup() {
    when(assembler.fromDto(any())).thenReturn(TestsUtils.createDefaultEntity());
    doNothing().when(validator).validate(any());
  }

  @Test
  public void shouldSucceed() {
    when(repository.findById(TestsUtils.DEFAULT_ID)).thenReturn(Optional.empty());
    objectUnderTests.createReport(new ReportItemDto());
  }

  @Test
  public void shouldFailOnAlreadyExistingObjectWithId() {
    assertThrows(ReportAlreadyExistsException.class, () -> {
      when(repository.findById(TestsUtils.DEFAULT_ID)).thenReturn(Optional.ofNullable(TestsUtils.createDefaultEntity()));
      objectUnderTests.createReport(new ReportItemDto());
    });
  }
}