package com.pradipta.reportsuspect.apis.stock.model.hospital;

import com.pradipta.reportsuspect.apis.stock.model.stock.Stock;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Data
@Entity
public class Hospital {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String city;
    private String state;
    @OneToOne
    private Stock stock;
}
