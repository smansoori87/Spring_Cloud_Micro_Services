package com.ce.service;

import java.math.BigDecimal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyExchangeController {

	@GetMapping("/currency-exchange-rate/api/v1/from/{from}/to/{to}")
	public CurrencyExchangeModel currencyExchange(@PathVariable String from, @PathVariable String to) {
		CurrencyExchangeModel cem =new CurrencyExchangeModel();
		cem.setId(1000L);
		cem.setFrom(from);
		cem.setTo(to);
		return cem;
	}
}
