package com.thrifty.picks.conference;

public class ConferenceMapper {

	public ConferenceDto toDto(Conference conference) {
		return new ConferenceDto(
			conference.getId(),
			conference.getName(),
			conference.getAbbreviation(),
			conference.isPowerConference()
		);
	}

}
