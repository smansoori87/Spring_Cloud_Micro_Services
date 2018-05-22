package com.cs.feign.proxy;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.cs.model.CurrencyConverterBean;

//@FeignClient(name = "currency-exchange-rate-service", url = "localhost:8000")
//@FeignClient(name = "currency-exchange-rate-service")

@FeignClient(name = "netflix-zuul-api-gateway-server")
@RibbonClient(name="currency-exchange-rate-service")
public interface ExchangeRateControllerProxy {

	//As using Api gateway, any uri has to append with its application name.
	//@GetMapping("/exchange-rate/api/v1/from/{from}/to/{to}")
	@GetMapping("/currency-exchange-rate-service/exchange-rate/api/v1/from/{from}/to/{to}")	
	public CurrencyConverterBean currencyExchange(@PathVariable("from") String from, @PathVariable("to") String to);
}
