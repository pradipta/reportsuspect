package com.pradipta.reportsuspect.apis.stock.model.stock;

import com.pradipta.reportsuspect.apis.stock.dto.StockDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StockHandler {
    @Autowired
    private StockService stockService;

    public Stock addStockByStockDto(StockDto stockDto) {
        Stock stock = stockFromStockDto(stockDto);
        return stockService.addStock(stock);
    }

    private Stock stockFromStockDto(StockDto stockDto) {
        //TODO pradipta
        return new Stock();
    }
}
