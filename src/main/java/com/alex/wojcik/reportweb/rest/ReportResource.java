package com.alex.wojcik.reportweb.rest;

import com.alex.wojcik.reportweb.dto.ReportItemDto;
import com.alex.wojcik.reportweb.service.ReportService;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("report")
public class ReportResource {

  private static final Logger LOG = LoggerFactory.getLogger(ReportResource.class);

  @Autowired
  private ReportService service;


  @RequestMapping(value = "/clear", method = RequestMethod.DELETE)
  public ResponseEntity clearAllReports() {
    service.clearAllReports();
    return ResponseEntity.ok().build();
  }

  @RequestMapping(value = "/all", method = RequestMethod.GET)
  public ResponseEntity<List<ReportItemDto>> getAllReports() {
    return ResponseEntity.ok(service.getAllReports());
  }

  @RequestMapping(method = RequestMethod.POST)
  public ResponseEntity createReport(@RequestBody ReportItemDto dto) {
    try {
      service.createReport(dto);
      return ResponseEntity.ok().build();
    } catch (RuntimeException e) {
      LOG.error("Failed to create report", e);
      return ResponseEntity.internalServerError().body(e.getMessage());
    }
  }
}
