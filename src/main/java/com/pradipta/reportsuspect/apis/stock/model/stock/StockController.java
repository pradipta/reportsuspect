package com.pradipta.reportsuspect.apis.stock.model.stock;

import com.pradipta.reportsuspect.apis.stock.dto.StockDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stock")
public class StockController {
    @Autowired
    private StockHandler stockHandler;

    @PostMapping("/addNewStock")
    private Stock addStock(@RequestBody StockDto stockDto) {
        return stockHandler.addStockByStockDto(stockDto);
    }

    @GetMapping("/getStockByHospital")
    private Stock getStock(@PathVariable("hospitalid") Integer hospitalid) {
        return stockHandler.getStockById(hospitalid);
    }
}
