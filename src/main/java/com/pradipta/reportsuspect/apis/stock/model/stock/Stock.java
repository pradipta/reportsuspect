package com.pradipta.reportsuspect.apis.stock.model.stock;

import com.pradipta.reportsuspect.apis.stock.model.hospital.Hospital;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Data
@Entity
public class Stock {
    @Id
    @OneToOne
    private Hospital hospital;
    private int masks;
    private int ventilators;
    private int beds;
    private int vaccines;
}
