package com.thakur.microservices.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("currency-exchange-service")
public class CurrencyExchangeConfiguration {

	private String converterOne;
	private String converterTwo;
	
	public CurrencyExchangeConfiguration() {
		
	}
	
	public CurrencyExchangeConfiguration(String converterOne, String converterTwo) {
		super();
		this.converterOne = converterOne;
		this.converterTwo = converterTwo;
	}

	public String getConverterOne() {
		return converterOne;
	}

	public void setConverterOne(String converterOne) {
		this.converterOne = converterOne;
	}

	public String getConverterTwo() {
		return converterTwo;
	}

	public void setConverterTwo(String converterTwo) {
		this.converterTwo = converterTwo;
	}
	
	
}
