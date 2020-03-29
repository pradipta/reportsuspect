package com.pradipta.reportsuspect.apis.stock.model.stock;

import com.pradipta.reportsuspect.apis.stock.dto.StockDto;
import com.pradipta.reportsuspect.apis.stock.model.hospital.Hospital;
import com.pradipta.reportsuspect.apis.stock.model.hospital.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class StockHandler {
    @Autowired
    private StockService stockService;
    @Autowired
    private HospitalService hospitalService;

    public Stock addStockByStockDto(StockDto stockDto) {
        Stock stock = stockFromStockDto(stockDto);
        return stockService.addStock(stock);
    }

    private Stock stockFromStockDto(StockDto stockDto) {
        //TODO pradipta
        return new Stock();
    }

    public Stock getStockById(Integer id) {
        Optional<Hospital> hospital = hospitalService.getHospitalById(id);
        if (!hospital.isPresent()) {
            return null;
        }
        return stockService.findStockByHospital(hospital.get()).orElse(null);
    }
}
