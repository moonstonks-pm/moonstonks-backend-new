package com.moonstonks.moonstonksbackendnew.service;

import com.moonstonks.moonstonksbackendnew.model.API.GlobalQuote;
import com.moonstonks.moonstonksbackendnew.model.Holding;
import com.moonstonks.moonstonksbackendnew.repository.HoldingRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HoldingServiceImpl implements HoldingService {

    private final HoldingRepository holdingRepository;

    private RestTemplate restTemplate = new RestTemplate();

    private String token = "Q81VYPZ66LS901H2";

    public HoldingServiceImpl(HoldingRepository holdingRepository) {
        this.holdingRepository = holdingRepository;
    }

    @Override
    public Holding getHolding(String symbol) {

        Holding holding = restTemplate.getForObject("https://www.alphavantage.co/query?function=OVERVIEW&symbol="+symbol+"&apikey="+token, Holding.class);
        GlobalQuote gq = restTemplate.getForObject("https://www.alphavantage.co/query?function=GLOBAL_QUOTE&symbol="+symbol+"&apikey="+token, GlobalQuote.class);

        holding.setCurrentPrice(gq.globalQuote.getCurrentPrice());
        return holding;
    }

}
