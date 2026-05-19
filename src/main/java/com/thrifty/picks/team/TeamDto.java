package com.thrifty.picks.team;

import com.thrifty.picks.conference.Conference;

public record TeamDto(
	String league,
	String espnCode,
	String cbsCode,
	String foxCode,
	String vegasCode,
	String division,
	String name,
	String mascot,
	String logoUrl,
	String darkLogoUrl,
	String primaryColor,
	String alternateColor,
	short ranking
) {}
