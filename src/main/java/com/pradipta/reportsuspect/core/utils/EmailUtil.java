package com.pradipta.reportsuspect.core.utils;

import com.pradipta.reportsuspect.core.constants.Status;
import com.pradipta.reportsuspect.apis.report.model.report.Report;
import com.pradipta.reportsuspect.apis.report.model.report.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;


@Component
@EnableScheduling
public class EmailUtil {
    @Autowired
    private ReportService reportService;
    @Autowired
    private JavaMailSender javaMailSender;


//    @Scheduled (cron = "* * * * * *")
    public void sendEmail() {
        SimpleMailMessage msg = new SimpleMailMessage();

        List<Report> reports = reportService.getAllPendingReports();
        System.out.println("Pending reports: "+reports.size());
        msg.setTo("pradiptasarma@outlook.com");
        msg.setSubject("Reported covid suspect");

        AtomicReference<String> content = new AtomicReference<>("New Reports:\n\n");

        reports.stream().forEach((report) -> {
            content.set(content + report.toString() + "\n\n");
            report.setStatus(Status.PROCESSED);
            reportService.saveReport(report);
        });

        msg.setText(content.get());
        if (reports.size()>0)
            javaMailSender.send(msg);
    }
}
