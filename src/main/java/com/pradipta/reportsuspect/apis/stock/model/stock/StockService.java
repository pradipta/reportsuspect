package com.pradipta.reportsuspect.apis.stock.model.stock;

import com.pradipta.reportsuspect.apis.stock.model.hospital.Hospital;
import com.pradipta.reportsuspect.apis.stock.model.hospital.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class StockService {
    @Autowired
    private StockRepository stockRepository;
    @Autowired
    private HospitalService hospitalService;
    public Stock addStock(Stock stock) {
        return stockRepository.save(stock);
    }

    public Stock updateStock(Stock stock, Integer hospitalId) {
        Optional<Hospital> hospitalOptional = hospitalService.getHospitalById(hospitalId);
        if (!hospitalOptional.isPresent()) {
            return null;
        }
        if (hospitalOptional.get().getStock() == null) {
            Stock generatedStock = stockRepository.save(stock);
            Hospital hospital = hospitalOptional.get();
            hospital.setStock(generatedStock);
            hospitalService.addHospital(hospital);
        }
        stock.setId(hospitalOptional.get().getStock().getId());
        return stockRepository.save(stock);
    }
}
