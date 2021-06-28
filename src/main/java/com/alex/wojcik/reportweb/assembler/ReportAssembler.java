package com.alex.wojcik.reportweb.assembler;

import com.alex.wojcik.reportweb.dto.ReportItemDto;
import com.alex.wojcik.reportweb.entity.ReportItem;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

@Component
public class ReportAssembler {

  public ReportItemDto toDto(ReportItem entity) {
    ReportItemDto dto = new ReportItemDto();
    dto.setId(entity.getId());
    dto.setStartDate(entity.getStartDate());
    dto.setEndDate(entity.getEndDate());
    dto.setDescription(StringUtils.trimToEmpty(entity.getDescription()));
    return dto;
  }

  public ReportItem fromDto(ReportItemDto dto) {
    ReportItem entity = new ReportItem();
    entity.setId(dto.getId());
    entity.setStartDate(dto.getStartDate());
    entity.setEndDate(dto.getEndDate());
    entity.setDescription(dto.getDescription());
    return entity;
  }
}
