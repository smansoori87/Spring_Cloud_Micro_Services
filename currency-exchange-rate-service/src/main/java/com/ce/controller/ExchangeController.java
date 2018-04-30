package com.ce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ce.data.Exchange;
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

	Exchange exc;

	@GetMapping("/exchange-rate/api/v1/from/{from}/to/{to}")
	public Exchange currencyExchange(@PathVariable String from, @PathVariable String to) {
//		System.out.println(">>>>>>>>>"+cem);
//		ExchangeModel em = new ExchangeModel(1000L, from, to, cem.getConversionMultiple(),
//				Integer.valueOf(env.getProperty("local.server.port")));
//		exc = em;

		ExchangeRate er = cevr.findByFromAndTo(from, to);
		er.setPort(Integer.valueOf(env.getProperty("local.server.port")));
		exc = er;

		return exc;
	}
}
