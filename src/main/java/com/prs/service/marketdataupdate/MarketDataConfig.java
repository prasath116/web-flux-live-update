package com.prs.service.marketdataupdate;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

@Configuration
public class MarketDataConfig {

	@Bean
    public Sinks.Many<MarketData> sink(){
        return Sinks.many().replay().latest();
    }

    @Bean
    @Qualifier("marketData")
    public Flux<MarketData> marketData(Sinks.Many<MarketData> sink){
        return sink.asFlux();
    }
    
}
