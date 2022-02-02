package com.prs.service.marketdataupdate;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MarketData {
	private String symbol;
	private double price;
}
