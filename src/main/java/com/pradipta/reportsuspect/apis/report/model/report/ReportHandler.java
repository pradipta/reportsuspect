package com.pradipta.reportsuspect.apis.report.model.report;

import com.google.gson.Gson;
import com.pradipta.reportsuspect.core.auth.models.user.UserService;
import com.pradipta.reportsuspect.core.constants.Status;
import com.pradipta.reportsuspect.apis.report.dto.ReportDto;
import com.pradipta.reportsuspect.apis.report.model.location.Location;
import com.pradipta.reportsuspect.apis.report.model.location.LocationService;
import com.pradipta.reportsuspect.apis.report.model.report.Report;
import com.pradipta.reportsuspect.apis.report.model.report.ReportService;
import com.pradipta.reportsuspect.core.utils.GsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Component
public class ReportHandler {
    @Autowired
    private ReportService reportService;
    @Autowired
    private UserService userService;
    @Autowired
    private LocationService locationService;
    @Autowired
    private GsonUtil gsonUtil;
    public Report saveReport(ReportDto reportDto) throws Exception{
        Report report = new Report();
        report.setCreatedOn(new Date());
        report.setModifiedOn(new Date());

        report.setRemarks(reportDto.getRemarks());
        report.setReporter(userService.findUserByEmail(SecurityContextHolder.getContext().getAuthentication().getName()).orElseThrow(Exception::new));

        report.setSuspectName(reportDto.getSuspectName());
        report.setSuspectPhoneNumber(reportDto.getSuspectPhoneNumber());
        report.setSuspectGender(reportDto.getSuspectGender());
        Location location = new Location();
        location.setLat(reportDto.getSuspectLocationLatitude());
        location.setLon(reportDto.getSuspectLocationLongitude());
        locationService.saveLocation(location);
        report.setSuspectCurrentLocation(location);
        report.setStatus(Status.PENDING);

        Location[] past = gsonUtil.gson.fromJson(reportDto.getVisitedLocation(), Location[].class);

        report.setVisitedLocation(Arrays.asList(past));
        return reportService.saveReport(report);
    }

    public Report getReport(int id) {
        Optional<Report> report = reportService.getReportById(id);
        if (!report.isPresent()) {
            return null;
        }
        return report.get();
    }

    public Report getReportByIdAndEmail(int id, String email) {
        Report report = getReport(id);
        if(report == null || !report.getReporter().getEmail().equalsIgnoreCase(email) )
            return null;
        return report;
    }
}
