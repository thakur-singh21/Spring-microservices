package com.thakur.microservices.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thakur.microservices.entity.ExchangeValue;

public interface ExchangeValueRepo extends JpaRepository<ExchangeValue, Integer>  {

	public ExchangeValue findByFromAndTo(String from, String to);
}
