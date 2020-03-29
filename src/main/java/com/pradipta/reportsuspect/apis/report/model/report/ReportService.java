package com.pradipta.reportsuspect.apis.report.model.report;

import com.pradipta.reportsuspect.core.constants.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ReportService {
    @Autowired
    private ReportRepository reportRepository;

    public Report saveReport(Report report) {
        return reportRepository.save(report);
    }

    public Optional<Report> getReportById(Integer id) {
        return reportRepository.findById(id);
    }

    public List<Report> getAllPendingReports() {
        return reportRepository.findAll().stream().filter(report -> report.getStatus().equals(Status.PENDING)).collect(Collectors.toList());
    }

    public void markProcessed(Report report) {
        //EntityManagerFactory emf = Persistence.createEntityManagerFactory();
    }
}
