package com.thrifty.picks.forecast;

import java.time.OffsetDateTime;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ForecastRepository extends JpaRepository<Forecast, ForecastId> {

	Optional<Forecast> findFirstByLocation_IdAndTimestampUtcLessThanEqualOrderByTimestampUtcDesc(
			String locationId, OffsetDateTime timestampUtc);

	Optional<Forecast> findFirstByLocation_IdOrderByTimestampUtcDesc(String locationId);
	
}
