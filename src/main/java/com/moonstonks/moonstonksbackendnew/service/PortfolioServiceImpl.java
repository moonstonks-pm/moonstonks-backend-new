package com.moonstonks.moonstonksbackendnew.service;

import com.moonstonks.moonstonksbackendnew.model.Holding;
import com.moonstonks.moonstonksbackendnew.model.Portfolio;
import com.moonstonks.moonstonksbackendnew.repository.PortfolioRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PortfolioServiceImpl implements PortfolioService {

    private PortfolioRepository portfolioRepository;
    private HoldingServiceImpl holdingService;

    public PortfolioServiceImpl(PortfolioRepository portfolioRepository, HoldingServiceImpl holdingService) {
        this.portfolioRepository = portfolioRepository;
        this.holdingService = holdingService;
    }

    @Override
    public Portfolio createPortfolio(Portfolio portfolio) {
        return portfolioRepository.save(portfolio);
    }

    @Override
    public void deletePortfolio(Long id) {
        portfolioRepository.deleteById(id);
    }

    @Override
    public Portfolio getPortfolio(Long id) {
        return portfolioRepository.findById(id).get();
    }

    @Override
    public String updatePortfolioName(Long id, String name) {
        boolean exists = portfolioRepository.existsById(id);
        if(!exists) {

            throw new IllegalStateException("Portfolio with id " + id + " does not exist");
        }else{
            Portfolio portfolio = portfolioRepository.findById(id).get();
            portfolio.setName(name);
            portfolioRepository.save(portfolio);
        }
        return name;
    }

    @Override
    public double getPortfolioRevenue(long id) {
        Portfolio portfolio = portfolioRepository.findById(id).get();
        return portfolio.getRevenue();
    }

    @Override
    public double getPortfolioRevenuePercent(long id) {
        Portfolio portfolio = portfolioRepository.findById(id).get();
        return portfolio.getRevenuePercent();
    }

    @Override
    public Holding addHolding(long id, String holdingSymbol, int amount) {
        Holding holding = holdingService.getHolding(holdingSymbol);
        holding.setAmountShares(amount);
        holding.setEntryPrice(holding.getCurrentPrice());
        holding.setPurchaseDate(LocalDateTime.now());
        Portfolio portfolio = portfolioRepository.findById(id).get();
        portfolio.getHoldings().add(holding);
        portfolio.calculatesPortfolioValue();
        portfolio.calculatesPortfolioRevenue();
        portfolioRepository.save(portfolio);
        return holding;
    }

    @Override
    public void removeHolding(Long id, String holdingSymbol, int amount) {
        //generate removeHolding function, which removes a specific amount of a Portfolio's holding filterd by Holding Symbol. If Holding Entry has lest shares then the ammount which should be removed , remove the rest of the next Holding entry

    }

    @Override
    public List<Holding> getAllHoldings(Long id) {
        return portfolioRepository.findById(id).get().getHoldings();
    }

    @Override
    public Portfolio updateValues(Long id) {
        Portfolio portfolio = portfolioRepository.findById(id).get();

        for (Holding holding : portfolio.getHoldings()) {
            holding.setCurrentPrice(holdingService.getHolding(holding.getSymbol()).getCurrentPrice());
        }

        return portfolioRepository.save(portfolio);

    }

}
