package com.pradipta.reportsuspect.apis.stock.model.hospital;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class Hospital {
    @Id
    private int id;
    private String name;
    private String city;
    private String state;
}
