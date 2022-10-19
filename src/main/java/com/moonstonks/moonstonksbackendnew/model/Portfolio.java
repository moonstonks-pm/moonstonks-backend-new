package com.moonstonks.moonstonksbackendnew.model;

import com.moonstonks.moonstonksbackendnew.repository.PortfolioRepository;
import com.moonstonks.moonstonksbackendnew.service.PortfolioServiceImpl;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "Portfolios")
public class Portfolio {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @Column(name = "portfolio_value")
    private double value;
    private double revenue;
    private double revenuePercent;
    private int holdingsAmount;
    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @JoinColumn(name= "portfolio_id")
    private List<Holding> holdings = new ArrayList<>();

    public Portfolio(String name, List<Holding> holdings) {
        this.name = name;
        this.holdings = holdings;
    }

    public Portfolio(String name) {
        this.name = name;
    }

    public Portfolio() {

    }

    public void calculatesPortfolioValue() {
        double totalValue = 0;
        for (Holding holding : holdings) {
            totalValue += holding.getCurrentPrice() * holding.getAmountShares();
        }
        this.value = totalValue;
    }

    public void calculatesPortfolioRevenue() {
        double totalRevenue = 0;
        for (Holding holding : holdings) {
            totalRevenue += (holding.getCurrentPrice() - holding.getEntryPrice()) * holding.getAmountShares();
        }
        this.revenue = totalRevenue;

    }

    public void calculatesPortfolioRevenuePercent() {
        // percent difference between value and revenue
        this.revenuePercent = (this.revenue / this.value) * 100;
    }
}
