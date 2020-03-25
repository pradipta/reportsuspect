package com.pradipta.reportsuspect.controller;

import com.pradipta.reportsuspect.dto.ReportDto;
import com.pradipta.reportsuspect.entity.Report;
import com.pradipta.reportsuspect.handler.ReportHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
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
    @GetMapping("/report")
    public ModelAndView showForm() {
        ReportDto reportDto = new ReportDto();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("reportDto", reportDto);
        modelAndView.setViewName("report");
        return modelAndView;
    }
    @PostMapping("/report")
    public ModelAndView report(@Valid ReportDto reportDto, BindingResult result, ModelMap modelMap) {
        System.out.println("here"+reportDto);
        ModelAndView modelAndView = new ModelAndView();
        if (result.hasErrors()) {
            modelAndView.addObject("successMessage", "Please correct the errors");
            modelMap.addAttribute("bindingResult", result);
        }
        else {
            reportHandler.saveReport(reportDto);
        }
        modelAndView.addObject("reportDto", new ReportDto());
        modelAndView.setViewName("report");
        return modelAndView;
    }

    @GetMapping("/status/{id}")
    public Report getStatus(@PathVariable("id") Integer id) {
        return reportHandler.getReport(id);
    }
}
