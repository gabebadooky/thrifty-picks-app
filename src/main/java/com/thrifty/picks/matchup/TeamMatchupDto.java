package com.thrifty.picks.matchup;

import com.thrifty.picks.bettingodds.BettingOddsDto;
import com.thrifty.picks.boxscore.BoxScoreDto;
import com.thrifty.picks.conference.ConferenceDto;
import com.thrifty.picks.stat.StatDto;
import com.thrifty.picks.team.TeamDto;
import java.util.List;

public record TeamMatchupDto(
	TeamDto info,
	ConferenceDto conference,
	BoxScoreDto boxscore,
	List<BettingOddsDto> bettingOdds,
	List<StatDto> stats
) {}
