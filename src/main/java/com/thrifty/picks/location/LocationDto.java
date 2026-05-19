package com.thrifty.picks.location;

public record LocationDto(
	String stadium,
	String city,
	String state,
	float latitude,
	float longitude
) {}