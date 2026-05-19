package com.thrifty.picks.game;

import com.thrifty.picks.location.Location;
import com.thrifty.picks.team.Team;
import java.time.OffsetDateTime;

public record GameDto(
	String id,
	String league,
	short week,
	short season,
	String espnCode,
	String cbsCode,
	String foxCode,
	String vegasCode,
	OffsetDateTime kickoffUtc,
	String broadcast,
	boolean finished
) {}
