package com.pradipta.reportsuspect.controller;

import com.pradipta.reportsuspect.dto.ReportDto;
import com.pradipta.reportsuspect.entity.Report;
import com.pradipta.reportsuspect.handler.ReportHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@RestController
public class ReportController {
    @Autowired
    private ReportHandler reportHandler;
    @CrossOrigin
    @GetMapping("/home")
    public ModelAndView showForm() {
        ReportDto reportDto = new ReportDto();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("reportDto", reportDto);
        modelAndView.setViewName("home");
        return modelAndView;
    }
    @CrossOrigin
    @PostMapping("/report")
    @Secured("ADMIN")
    public ModelAndView report(@Valid ReportDto reportDto, BindingResult result, ModelMap modelMap, SecurityContextHolder securityContextHolder) throws Exception {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        ModelAndView modelAndView = new ModelAndView();
        Report report = new Report();
        if (result.hasErrors()) {
            modelAndView.addObject("successMessage", "Please correct the errors");
            modelMap.addAttribute("bindingResult", result);
        }
        else {
            report = reportHandler.saveReport(reportDto);
        }
        modelAndView.addObject("report", report);
        modelAndView.setViewName("result");
        return modelAndView;
    }
    @CrossOrigin
    @PostMapping("/status/{id}")
    public Report getStatus(@PathVariable("id") Integer id) {
        return reportHandler.getReport(id);
    }
}
