package com.pradipta.reportsuspect.apis.stock.model.stock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StockService {
    @Autowired
    private StockRepository stockRepository;
    public Stock addStock(Stock stock) {
        return stockRepository.save(stock);
    }
}
