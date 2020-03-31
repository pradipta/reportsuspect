package com.pradipta.reportsuspect.apis.stock.controller;

import com.pradipta.reportsuspect.apis.stock.dto.StockDto;
import com.pradipta.reportsuspect.apis.stock.model.stock.Stock;
import com.pradipta.reportsuspect.apis.stock.model.stock.StockHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hospital/stock")
public class StockController {
    @Autowired
    private StockHandler stockHandler;

    @PostMapping("/{hospitalId}/updateStock")
    private Stock updateStock(@RequestBody StockDto stockDto, @PathVariable("hospitalId") Integer hospitalId) {
        return stockHandler.updateStockByStockDto(stockDto, hospitalId);
    }

    @GetMapping("/getStockByHospital")
    private Stock getStock(@PathVariable("hospitalid") Integer hospitalid) {
        return stockHandler.getStockByHospitalId(hospitalid);
    }
}
