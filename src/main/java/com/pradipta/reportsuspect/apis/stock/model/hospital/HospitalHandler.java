package com.pradipta.reportsuspect.apis.stock.model.hospital;

import com.pradipta.reportsuspect.apis.stock.dto.HospitalDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HospitalHandler {

    @Autowired
    private HospitalService hospitalService;

    public Hospital saveHospitalByDto(HospitalDto hospitalDto) {
        Hospital hospital = convertToHospital(hospitalDto);
        return hospitalService.addHospital(hospital);
    }

    private Hospital convertToHospital(HospitalDto hospitalDto) {
        Hospital hospital = new Hospital();
        hospital.setCity(hospitalDto.getCity());
        hospital.setName(hospitalDto.getName());
        hospital.setState(hospitalDto.getState());
        return new Hospital();
    }

    public Hospital getHospitalById(Integer id) {
        return hospitalService.getHospitalById(id).orElse(null);
    }
}
