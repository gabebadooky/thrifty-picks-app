package com.thrifty.picks.forecast;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ForecastRepository extends JpaRepository<Forecast, ForecastId> {}
