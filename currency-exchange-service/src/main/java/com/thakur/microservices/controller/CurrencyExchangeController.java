package com.thakur.microservices.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.thakur.microservices.config.CurrencyExchangeConfiguration;
import com.thakur.microservices.dao.ExchangeValueRepo;
import com.thakur.microservices.entity.ExchangeValue;

@RestController
public class CurrencyExchangeController {
	
	private Logger logger = LoggerFactory.getLogger(CurrencyExchangeController.class);
	
	@Autowired
	private Environment env;
	
	@Autowired
	private ExchangeValueRepo repo;

	@Autowired
	CurrencyExchangeConfiguration config;
	
	@GetMapping("/getconfig")
	public CurrencyExchangeConfiguration getExchangeConfig() {
		
		return new CurrencyExchangeConfiguration(config.getConverterOne(), config.getConverterTwo());
	}
	
	
	  @GetMapping("/currency-exchange/from/{from}/to/{to}") 
	  public ExchangeValue getExchangevalue(@PathVariable String from, @PathVariable String to) {
	  
		  ExchangeValue exchange = repo.findByFromAndTo(from, to);
		  logger.info("Exchange server {}", exchange);
		  exchange.setPort(Integer.parseInt(env.getProperty("local.server.port")));
		  
		  return exchange;
	  }
	 
}
