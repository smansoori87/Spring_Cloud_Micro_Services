package com.cs.feign.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.cs.model.CurrencyConverterBean;

@FeignClient(name = "currency-exchange-rate-service", url = "localhost:8000")
public interface ExchangeRateControllerProxy {

	@GetMapping("/exchange-rate/api/v1/from/{from}/to/{to}")
	public CurrencyConverterBean currencyExchange(@PathVariable("from") String from, @PathVariable("to") String to);
}
