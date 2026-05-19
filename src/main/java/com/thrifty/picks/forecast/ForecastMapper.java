package com.thrifty.picks.forecast;

public class ForecastMapper {

	public ForecastDto toDto(Forecast forecast) {
		return new ForecastDto(
			forecast.getTemperature(),
			forecast.getFeelsLike(),
			forecast.getHumidity(),
			forecast.getVisibility(),
			forecast.getWindSpeed(),
			forecast.getShortDescription(),
			forecast.getLongDescription()
		);
	}

}
