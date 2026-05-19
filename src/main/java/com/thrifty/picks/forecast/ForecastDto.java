package com.thrifty.picks.forecast;

public record ForecastDto(
	Float temperature,
	Float feelsLike,
	Float humidity,
	Float visibility,
	Float windSpeed,
	String shortDescription,
	String longDescription
) {}
