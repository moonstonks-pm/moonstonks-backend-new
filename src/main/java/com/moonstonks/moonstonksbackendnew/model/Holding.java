package com.moonstonks.moonstonksbackendnew.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Holding {

    private String symbol;
    private String name;
    private String description;
    private double price;
    private int amountShares;



}
