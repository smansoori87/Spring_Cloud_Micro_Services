package com.cs.controller;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.cs.model.CurrencyConverterBean;

@RestController
public class CurrencyConversionController {

	@Autowired
	Environment env;

	@GetMapping("/currency-conversion/api/v1/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConverterBean currencyConverter(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quantity) {

		Map<String, String> uriVar = new HashMap<String, String>();
		uriVar.put("from", from);
		uriVar.put("to", to);
		ResponseEntity<CurrencyConverterBean> re = new RestTemplate().getForEntity("http://localhost:8000/exchange-rate/api/v1/from/{from}/to/{to}",
				CurrencyConverterBean.class, uriVar);
		CurrencyConverterBean ccb = re.getBody();
		System.out.println(">>>>>>>>>>>" + ccb);

		return new CurrencyConverterBean(ccb.getId(), from, to, ccb.getConversionMultiple(), quantity, ccb.getConversionMultiple().multiply(quantity),
				Integer.valueOf(env.getProperty("local.server.port")));
	}
}
