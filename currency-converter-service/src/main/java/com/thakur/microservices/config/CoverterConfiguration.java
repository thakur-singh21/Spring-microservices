package com.thakur.microservices.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("currency-converter-service")
public class CoverterConfiguration {

	private int usdtoinrConversionFactor;
	private int eurtoinrConversionFactor;
	
	public CoverterConfiguration() {
	
	}
	
	public CoverterConfiguration(int usdtoinrConversionFactor, int eurtoinrConversionFactor) {
		super();
		this.usdtoinrConversionFactor = usdtoinrConversionFactor;
		this.eurtoinrConversionFactor = eurtoinrConversionFactor;
	}

	public int getUsdtoinrConversionFactor() {
		return usdtoinrConversionFactor;
	}

	public void setUsdtoinrConversionFactor(int usdtoinrConversionFactor) {
		this.usdtoinrConversionFactor = usdtoinrConversionFactor;
	}

	public int getEurtoinrConversionFactor() {
		return eurtoinrConversionFactor;
	}

	public void setEurtoinrConversionFactor(int eurtoinrConversionFactor) {
		this.eurtoinrConversionFactor = eurtoinrConversionFactor;
	}
	
	
}
