package com.thrifty.picks.matchup;

import com.thrifty.picks.bettingodds.BettingOdds;
import com.thrifty.picks.bettingodds.BettingOddsMapper;
import com.thrifty.picks.boxscore.BoxScore;
import com.thrifty.picks.boxscore.BoxScoreMapper;
import com.thrifty.picks.conference.ConferenceMapper;
import com.thrifty.picks.forecast.Forecast;
import com.thrifty.picks.forecast.ForecastMapper;
import com.thrifty.picks.game.Game;
import com.thrifty.picks.game.GameMapper;
import com.thrifty.picks.location.LocationMapper;
import com.thrifty.picks.stat.Stat;
import com.thrifty.picks.stat.StatMapper;
import com.thrifty.picks.team.Team;
import com.thrifty.picks.team.TeamMapper;
import java.util.List;

public class MatchupMapper {

	private final GameMapper gameMapper = new GameMapper();
	private final TeamMapper teamMapper = new TeamMapper();
	private final ConferenceMapper conferenceMapper = new ConferenceMapper();
	private final BoxScoreMapper boxScoreMapper = new BoxScoreMapper();
	private final BettingOddsMapper bettingOddsMapper = new BettingOddsMapper();
	private final StatMapper statMapper = new StatMapper();
	private final LocationMapper locationMapper = new LocationMapper();
	private final ForecastMapper forecastMapper = new ForecastMapper();

	public MatchupDto toDto(
			Game game,
			BoxScore awayBoxScore,
			List<BettingOdds> awayBettingOdds,
			List<Stat> awayStats,
			BoxScore homeBoxScore,
			List<BettingOdds> homeBettingOdds,
			List<Stat> homeStats,
			Forecast forecast) {
		return new MatchupDto(
			gameMapper.toDto(game),
			toTeamMatchup(game.getAwayTeam(), awayBoxScore, awayBettingOdds, awayStats),
			toTeamMatchup(game.getHomeTeam(), homeBoxScore, homeBettingOdds, homeStats),
			locationMapper.toDto(game.getLocation()),
			forecast != null ? forecastMapper.toDto(forecast) : null
		);
	}

	private TeamMatchupDto toTeamMatchup(
			Team team,
			BoxScore boxScore,
			List<BettingOdds> bettingOdds,
			List<Stat> stats) {
		return new TeamMatchupDto(
			teamMapper.toDto(team),
			conferenceMapper.toDto(team.getConference()),
			boxScore != null ? boxScoreMapper.toDto(boxScore) : null,
			bettingOdds.stream().map(bettingOddsMapper::toDto).toList(),
			stats.stream().map(statMapper::toDto).toList()
		);
	}
	
}
