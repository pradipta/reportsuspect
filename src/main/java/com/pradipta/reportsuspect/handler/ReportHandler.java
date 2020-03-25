package com.pradipta.reportsuspect.handler;

import com.pradipta.reportsuspect.constants.Status;
import com.pradipta.reportsuspect.dto.ReportDto;
import com.pradipta.reportsuspect.entity.Report;
import com.pradipta.reportsuspect.entity.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Optional;

@Component
public class ReportHandler {
    @Autowired
    private ReportService reportService;
    public Report saveReport(ReportDto reportDto) {
        Report report = new Report();
        report.setCreatedOn(new Date());
        report.setModifiedOn(new Date());

        report.setRemarks(reportDto.getRemarks());
        report.setReporterEmail(reportDto.getReporterEmail());
        report.setReporterCity(reportDto.getReporterCity());
        report.setReporterFirstname(reportDto.getReporterFirstname());
        report.setReporterLastname(reportDto.getReporterLastname());
        report.setReporterPhonenumber(reportDto.getReporterPhonenumber());
        report.setReporterZipcode(report.getReporterZipcode());

        report.setSuspectAddess(reportDto.getSuspectAddress());
        report.setSuspectName(reportDto.getSuspectName());
        report.setSuspectCity(reportDto.getSuspectCity());
        report.setSuspectPhoneNumber(reportDto.getSuspectPhoneNumber());
        report.setSuspectGender(reportDto.getSuspectGender());
        report.setSuspectZipcode(reportDto.getSuspectZipcode());

        report.setStatus(Status.PENDING);
        return reportService.saveReport(report);
    }

    public Report getReport(int id) {
        Optional<Report> report = reportService.getReportById(id);
        if (!report.isPresent()) {
            return null;
        }
        return report.get();
    }
}
