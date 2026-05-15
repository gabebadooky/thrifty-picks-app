package com.thrifty.picks.forecast;

import com.thrifty.picks.location.Location;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.OffsetDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "forecast", schema = "pickem")
@IdClass(ForecastId.class)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Forecast {

	@Id
	@ManyToOne(optional = false)
	@JoinColumn(name = "location", nullable = false)
	private Location location;

	@Id
	@Column(name = "timestamp_utc", nullable = false)
	private OffsetDateTime timestampUtc;

	private Float temperature;

	@Column(name = "feels_like")
	private Float feelsLike;

	private Float humidity;

	private Float visibility;

	@Column(name = "wind_speed")
	private Float windSpeed;

	@Column(name = "short_description", length = 100)
	private String shortDescription;

	@Column(name = "long_description", length = 100)
	private String longDescription;

	@UpdateTimestamp
	@Column(name = "updated_at", nullable = false)
	private OffsetDateTime updatedAt;
}
