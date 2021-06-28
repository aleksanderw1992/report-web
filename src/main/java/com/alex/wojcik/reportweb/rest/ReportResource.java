package com.alex.wojcik.reportweb.rest;

import com.alex.wojcik.reportweb.dto.ReportItemDto;
import com.alex.wojcik.reportweb.service.ReportService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("report")
public class ReportResource {
  @Autowired
  private ReportService service;


  @RequestMapping(value = "/clear", method = RequestMethod.DELETE)
  public void clearAllReports() {
    service.clearAllReports();
  }

  @RequestMapping(value = "/all", method = RequestMethod.GET)
  public List<ReportItemDto> getAllReports() {
    return service.getAllReports();
  }

  @RequestMapping(method = RequestMethod.POST)
  public void createReport(@RequestBody ReportItemDto dto) {
    service.createReport(dto);
  }


}
