package com.prs.service.marketdataupdate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Sinks;

@Service
public class MarketDataPublisher {
	@Autowired
	@Qualifier("sinkLive")
    private Sinks.Many<MarketData> sinkLive;
	
	@Autowired
	@Qualifier("sinkAll")
    private Sinks.Many<MarketData> sinkAll;

	double data = 0.1;
    @Scheduled(fixedRate = 1500)
    public void publish(){
    	var v = new MarketData("AAPL",data++);
    	sinkLive.tryEmitNext(v);
    	sinkAll.tryEmitNext(v);
    }
}
