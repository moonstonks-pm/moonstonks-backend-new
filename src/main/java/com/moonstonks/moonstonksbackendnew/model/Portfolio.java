package com.moonstonks.moonstonksbackendnew.model;

import lombok.Data;

@Data
public class Portfolio {

    private String name;
    private double value;
    private double revenue;
    private double revenuePercent;
    private int holdingsAmount;
    private Holding[] holdings;

    public Portfolio(String name, Holding[] holdings) {
        this.name = name;
        this.holdings = holdings;
    }

    public Portfolio(String name) {
        this.name = name;
    }
}
