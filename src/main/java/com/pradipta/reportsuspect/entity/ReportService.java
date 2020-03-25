package com.pradipta.reportsuspect.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReportService {
    @Autowired
    private ReportRepository reportRepository;

    public Report saveReport(Report report) {
        return reportRepository.save(report);
    }
}
