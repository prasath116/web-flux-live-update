package com.prs.service.marketdataupdate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Sinks;

@Service
public class MarketDataPublisher {
	@Autowired
    private Sinks.Many<MarketData> sink;

    @Scheduled(fixedRate = 3000)
    public void publish(){
    	sink.tryEmitNext(new MarketData("AAPL",Math.random()));
    }
}
