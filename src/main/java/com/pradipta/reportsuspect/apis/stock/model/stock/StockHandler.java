package com.pradipta.reportsuspect.apis.stock.model.stock;

import com.pradipta.reportsuspect.apis.stock.dto.StockDto;
import com.pradipta.reportsuspect.apis.stock.model.hospital.Hospital;
import com.pradipta.reportsuspect.apis.stock.model.hospital.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StockHandler {
    @Autowired
    private StockService stockService;

    @Autowired
    private HospitalService hospitalService;

    public Stock updateStockByStockDto(StockDto stockDto, Integer hospitalId) {
        Stock stock = stockFromStockDto(stockDto);
        return stockService.updateStock(stockDto, hospitalId);
    }

    private Stock stockFromStockDto(StockDto stockDto) {
        Stock newStock = new Stock();
        newStock.setBeds(stockDto.getBeds());
        newStock.setMasks(stockDto.getMasks());
        newStock.setVaccines(stockDto.getVaccines());
        newStock.setVentilators(stockDto.getVentilators());
        return newStock;
    }

    public Stock getStockByHospitalId(Integer hospitalId) {
        Optional<Hospital> hospital = hospitalService.getHospitalById(hospitalId);
        if (!hospital.isPresent()) {
            return null;
        }
        return hospital.get().getStock();
    }
}
