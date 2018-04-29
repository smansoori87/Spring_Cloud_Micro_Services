package com.ce.data;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ExchangeRateRepository extends JpaRepository<ExchangeRate, Long>{

	ExchangeRate findByFromAndTo(String from, String to);
}
