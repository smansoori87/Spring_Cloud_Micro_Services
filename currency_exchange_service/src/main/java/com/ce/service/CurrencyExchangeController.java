package com.ce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyExchangeController {

	@Autowired
	CurrencyExchangeModel cem;
	@Autowired
	Environment env;
	
	@GetMapping("/currency-exchange-rate/api/v1/from/{from}/to/{to}")
	public CurrencyExchangeModel currencyExchange(@PathVariable String from, @PathVariable String to) {
		CurrencyExchangeModel ceModel = new CurrencyExchangeModel(1000L, from, to, cem.getConversionMultiple(), 0);
		ceModel.setPort(Integer.valueOf(env.getProperty("local.server.port")));
		return ceModel;
	}
}
