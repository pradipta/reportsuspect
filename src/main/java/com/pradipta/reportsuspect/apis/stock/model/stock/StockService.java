package com.pradipta.reportsuspect.apis.stock.model.stock;

import com.pradipta.reportsuspect.apis.stock.model.hospital.Hospital;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StockService {
    @Autowired
    private StockRepository stockRepository;

    public Optional<Stock> findStockByHospital (Hospital hospital) {
        return stockRepository.findById(hospital);
    }
    public Stock addStock(Stock stock) {
        return stockRepository.save(stock);
    }
}
