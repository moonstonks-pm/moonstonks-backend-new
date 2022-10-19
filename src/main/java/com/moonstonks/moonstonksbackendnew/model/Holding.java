package com.moonstonks.moonstonksbackendnew.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@AllArgsConstructor
@Entity
@Data
@Table(name = "Holding")
public class Holding {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @JsonProperty("Symbol")
    private String symbol;
    @JsonProperty("Name")
    private String name;
    @JsonProperty("Description")
    @Column(columnDefinition="TEXT", length = 2000)
    private String description;
    private double entryPrice;
    private double currentPrice;
    private int amountShares;
    @JsonProperty("Country")
    private String country;
    @JsonProperty("AssetType")
    private String type;
    @JsonProperty("Currency")
    private String currency;
    @JsonProperty("Sector")
    private String sector;
    @JsonProperty("Industry")
    private String industry;
    private LocalDateTime purchaseDate;



    public Holding() {

    }
}
