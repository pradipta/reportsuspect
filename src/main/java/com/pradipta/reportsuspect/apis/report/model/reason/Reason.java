package com.pradipta.reportsuspect.apis.report.model.reason;

import com.pradipta.reportsuspect.core.constants.ReasonsEnum;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Reason {
    @Id
    private int id;
    private ReasonsEnum reason;
}
