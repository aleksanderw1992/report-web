package com.alex.wojcik.reportweb.service;

import com.alex.wojcik.reportweb.assembler.ReportAssembler;
import com.alex.wojcik.reportweb.dto.ReportItemDto;
import com.alex.wojcik.reportweb.entity.ReportItem;
import com.alex.wojcik.reportweb.exception.ReportAlreadyExistsException;
import com.alex.wojcik.reportweb.repository.ReportItemRepository;
import java.util.List;
import java.util.stream.Collectors;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ReportService {

  @Autowired
  private ReportItemRepository repository;

  @Autowired
  private ReportAssembler assembler;


  public void clearAllReports() {
    repository.deleteAll();
  }

  public List<ReportItemDto> getAllReports() {
    return repository.findAll().stream().map(assembler::toDto).collect(Collectors.toList());
  }

  public void createReport(ReportItemDto dto) {
    ReportItem newEntity = assembler.fromDto(dto);
    if (repository.findById(newEntity.getId()).isPresent()) {
      throw new ReportAlreadyExistsException(dto.getId());
    }
    repository.save(newEntity);
  }
}
