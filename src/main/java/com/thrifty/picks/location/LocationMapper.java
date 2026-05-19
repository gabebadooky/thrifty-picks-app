package com.thrifty.picks.location;

public class LocationMapper {

	public LocationDto toDto(Location location) {
		return new LocationDto(
			location.getStadium(),
			location.getCity(),
			location.getState(),
			location.getLatitude(),
			location.getLongitude()
		);
	}

}
