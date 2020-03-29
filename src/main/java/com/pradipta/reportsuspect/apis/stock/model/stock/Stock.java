package com.pradipta.reportsuspect.apis.stock.model.stock;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Stock {
    @Id
    @GeneratedValue
    private int id;
    private int masks;
    private int ventilators;
    private int beds;
    private int vaccines;
}
