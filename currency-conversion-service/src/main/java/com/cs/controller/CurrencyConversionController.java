package com.cs.controller;

import java.math.BigDecimal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.cs.model.CurrencyConverterBean;

@RestController
public class CurrencyConversionController {

	@GetMapping("/currency-conversion/api/v1/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConverterBean currencyConverter(@PathVariable String from, @PathVariable String to,
			@PathVariable BigDecimal quantity) {

		return null;// new CurrencyConverterBean(10001L, from, to, BigDecimal.valueOf(10),quantity, 10, 0);
	}
}
