package com.thrifty.picks.matchup;

import com.thrifty.picks.forecast.ForecastDto;
import com.thrifty.picks.game.GameDto;
import com.thrifty.picks.location.LocationDto;

public record MatchupDto(
	GameDto info,
	TeamMatchupDto awayTeam,
	TeamMatchupDto homeTeam,
	LocationDto location,
	ForecastDto forecast
) {}
