package com.pradipta.reportsuspect.controller;

import com.pradipta.reportsuspect.dto.ReportDto;
import com.pradipta.reportsuspect.entity.Report;
import com.pradipta.reportsuspect.handler.ReportHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReportController {
    @Autowired
    private ReportHandler reportHandler;
    @PostMapping("/report")
    public Report report(@RequestBody ReportDto reportDto) {
        return reportHandler.saveReport(reportDto);
    }
}
