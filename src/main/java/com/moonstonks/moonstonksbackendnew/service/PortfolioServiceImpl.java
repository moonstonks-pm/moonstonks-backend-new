package com.moonstonks.moonstonksbackendnew.service;

import com.moonstonks.moonstonksbackendnew.model.API.GlobalQuote;
import com.moonstonks.moonstonksbackendnew.model.Holding;
import com.moonstonks.moonstonksbackendnew.model.Portfolio;
import com.moonstonks.moonstonksbackendnew.repository.PortfolioRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import java.time.LocalDateTime;
import java.util.List;

@Service
public class PortfolioServiceImpl implements PortfolioService {

    private PortfolioRepository portfolioRepository;
    private HoldingServiceImpl holdingService;

    private RestTemplate restTemplate = new RestTemplate();

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
        portfolio.calculatesPortfolioRevenue();
        return portfolio.getRevenue();
    }

    @Override
    public double getPortfolioRevenuePercent(long id) {
        Portfolio portfolio = portfolioRepository.findById(id).get();
        portfolio.calculatesPortfolioRevenuePercent();
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

        // loop through all Holdings of a portfolio, if holdingSymbol matches save them in a list, if amount is bigger than the amountShares of the holding, remove the holding and subtract the amount from the amount of the next holding, if amount is smaller than the amountShares of the holding, subtract the amount from the amountShares of the holding, if amount is equal to the amountShares of the holding, remove the holding.

        Portfolio portfolio = portfolioRepository.findById(id).get();
        List<Holding> holdingList = portfolio.getHoldings();
        int amountLeft = amount;
        while(amountLeft != 0){
            for (Holding holding : holdingList) {
                if(holding.getSymbol().equals(holdingSymbol)){
                    if(amountLeft > holding.getAmountShares()){
                        amountLeft -= holding.getAmountShares();
                        holdingList.remove(holding);
                    }else if(amountLeft < holding.getAmountShares()){
                        holding.setAmountShares(holding.getAmountShares() - amountLeft);
                        amountLeft = 0;
                    }else if (amountLeft == holding.getAmountShares()){
                        holdingList.remove(holding);
                        amountLeft = 0;
                    }
                } else if(holding == null){
                    throw new IllegalStateException("Holding with symbol " + holdingSymbol + " does not exist");
                }
            }
        }
        portfolio.setHoldings(holdingList);
        portfolio.calculatesPortfolioValue();
        portfolio.calculatesPortfolioRevenue();
        portfolioRepository.save(portfolio);
    }

    @Override
    public List<Holding> getAllHoldings(Long id) {
        return portfolioRepository.findById(id).get().getHoldings();
    }

    @Override
    public Portfolio updateValues(Long id) {
        Portfolio portfolio = portfolioRepository.findById(id).get();
        //GlobalQuote gq = restTemplate.getForObject("https://www.alphavantage.co/query?function=GLOBAL_QUOTE&symbol=AMZ.DEX&apikey=Q81VYPZ66LS901H2", GlobalQuote.class);

        for (Holding holding : portfolio.getHoldings()) {
            holding.setCurrentPrice(holdingService.getHolding(holding.getSymbol()).getCurrentPrice());
        }
        portfolio.calculatesPortfolioValue();
        portfolio.calculatesPortfolioRevenue();
        portfolio.calculatesPortfolioRevenuePercent();
        return portfolioRepository.save(portfolio);

    }
}
