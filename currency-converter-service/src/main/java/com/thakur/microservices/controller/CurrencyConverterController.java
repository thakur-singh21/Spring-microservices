package com.thakur.microservices.controller;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thakur.microservices.CurrencyConversionBeen;
import com.thakur.microservices.config.CoverterConfiguration;
import com.thakur.microservices.proxy.CurrencyExchangeServiceProxy;

@RestController
public class CurrencyConverterController {
	
	private Logger logger = LoggerFactory.getLogger(CurrencyConverterController.class);
	
	@Autowired
	private CurrencyExchangeServiceProxy proxy;
	
	@Autowired
	CoverterConfiguration converterConfig;

	@GetMapping("/getconfig")
	public CoverterConfiguration getCurrencyConverterConfig() {
		
		return new CoverterConfiguration(converterConfig.getUsdtoinrConversionFactor(), converterConfig.getEurtoinrConversionFactor());
	}
	
	@GetMapping("/convert-currency/from/{from}/to/{to}/quantity/{qty}")
	public CurrencyConversionBeen getCurrencyConversion(@PathVariable String from, @PathVariable String to,
			@PathVariable BigDecimal qty) {
		CurrencyConversionBeen response = proxy.getExchangevalue(from, to);
		logger.info("convertor service : {}", response);
		return new CurrencyConversionBeen(response.getId(), from, to, response.getConversionMultiple(), qty,
						qty.multiply(response.getConversionMultiple()), response.getPort());
		
	}
}
