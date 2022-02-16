package com.prs.service.marketdataupdate;

import java.time.Duration;
import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;

@RestController
public class MarketDataController {
	@Autowired
	@Qualifier("marketLiveData")
	private Flux<MarketData> marketLiveData;
	
	@Autowired
	@Qualifier("marketAllData")
	private Flux<MarketData> marketAllData;

	@GetMapping(value = "/getLiveData", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<MarketData> getData() {
		return marketLiveData;
	}
	
	@GetMapping(value = "/getAllData", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<MarketData> getAllData() {
		return marketAllData;
	}
	
	@GetMapping(path = "/stream-flux", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<String> streamFlux() {
	    return Flux.interval(Duration.ofSeconds(1))
	      .map(sequence -> "Flux - " + LocalTime.now().toString());
	}

}
