package com.prs.service.marketdataupdate;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

@Configuration
public class MarketDataConfig {

	@Bean
	@Qualifier("sinkLive")
	public Sinks.Many<MarketData> sinkLive() {
		return Sinks.many().replay().latest();
	}

	@Bean
	@Qualifier("sinkAll")
	public Sinks.Many<MarketData> sinkAll() {
		return Sinks.many().replay().all();
	}

	@Bean
	@Qualifier("marketLiveData")
	public Flux<MarketData> marketLiveData(Sinks.Many<MarketData> sinkLive) {
		return sinkLive.asFlux();
	}

	@Bean
	@Qualifier("marketAllData")
	public Flux<MarketData> marketAllData(Sinks.Many<MarketData> sinkAll) {
		return sinkAll.asFlux();
	}

}
