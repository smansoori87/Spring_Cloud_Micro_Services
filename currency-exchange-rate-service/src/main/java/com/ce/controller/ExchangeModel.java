package com.ce.controller;

import java.math.BigDecimal;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import com.ce.data.Exchange;

@Component
@ConfigurationProperties(prefix = "currency-exchange-rate-service.exchange-model")
public class ExchangeModel implements Exchange {

	private Long id;
	private String from;
	private String to;
	private BigDecimal conversionMultiple;
	private int port;

	public ExchangeModel() {
	}

	public ExchangeModel(Long id, String from, String to, BigDecimal conversionMultiple, int port) {
		super();
		this.id = id;
		this.from = from;
		this.to = to;
		this.conversionMultiple = conversionMultiple;
		this.port = port;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public BigDecimal getConversionMultiple() {
		return conversionMultiple;
	}

	public void setConversionMultiple(BigDecimal conversionMultiple) {
		this.conversionMultiple = conversionMultiple;
	}

	@Override
	public String toString() {
		return "CurrencyExchangeModel [id=" + id + ", from=" + from + ", to=" + to + ", conversionMultiple="
				+ conversionMultiple + ", port=" + port + "]";
	}
}