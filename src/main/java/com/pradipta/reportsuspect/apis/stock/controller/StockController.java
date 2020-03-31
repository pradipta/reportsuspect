package com.pradipta.reportsuspect.apis.stock.controller;

import com.pradipta.reportsuspect.apis.stock.dto.StockDto;
import com.pradipta.reportsuspect.apis.stock.model.stock.Stock;
import com.pradipta.reportsuspect.apis.stock.model.stock.StockHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/stock")
public class StockController {
    @Autowired
    private StockHandler stockHandler;

    @GetMapping("/update")
    public ModelAndView showForm(Authentication authentication) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("stockadd");
        return modelAndView;
    }

    @PostMapping("/{hospitalId}/updateStock")
    private Stock updateStock(@RequestBody StockDto stockDto, @PathVariable("hospitalId") Integer hospitalId) {
        return stockHandler.updateStockByStockDto(stockDto, hospitalId);
    }

    @GetMapping("/getStockByHospital/{hospitalid}")
    private Stock getStock(@PathVariable("hospitalid") Integer hospitalid) {
        return stockHandler.getStockByHospitalId(hospitalid);
    }
}
