package com.ce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ce.data.ExchangeRate;
import com.ce.data.ExchangeRateRepository;

@RestController
public class ExchangeController {

	@Autowired
	ExchangeModel cem;
	@Autowired
	Environment env;
	
	@Autowired
	ExchangeRateRepository cevr;
	
	@GetMapping("/exchange-rate/api/v1/from/{from}/to/{to}")
	public ExchangeRate currencyExchange(@PathVariable String from, @PathVariable String to) {
		/*ExchangeModel ceModel = new ExchangeModel(1000L, from, to, cem.getConversionMultiple(), 0);
		ceModel.setPort(Integer.valueOf(env.getProperty("local.server.port")));*/
		
		ExchangeRate er = cevr.findByFromAndTo(from, to);
		er.setPort(Integer.valueOf(env.getProperty("local.server.port")));
		
		return er;
	}
}
