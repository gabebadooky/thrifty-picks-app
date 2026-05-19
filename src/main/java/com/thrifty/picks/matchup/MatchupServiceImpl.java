package com.thrifty.picks.matchup;

import com.thrifty.picks.bettingodds.BettingOdds;
import com.thrifty.picks.bettingodds.BettingOddsRepository;
import com.thrifty.picks.boxscore.BoxScore;
import com.thrifty.picks.boxscore.BoxScoreRepository;
import com.thrifty.picks.forecast.Forecast;
import com.thrifty.picks.forecast.ForecastRepository;
import com.thrifty.picks.game.Game;
import com.thrifty.picks.game.GameRepository;
import com.thrifty.picks.location.Location;
import com.thrifty.picks.stat.Stat;
import com.thrifty.picks.stat.StatRepository;
import com.thrifty.picks.team.Team;
import java.time.OffsetDateTime;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MatchupServiceImpl implements MatchupService {

	private final GameRepository gameRepository;
	private final BoxScoreRepository boxScoreRepository;
	private final BettingOddsRepository bettingOddsRepository;
	private final StatRepository statRepository;
	private final ForecastRepository forecastRepository;
	private final MatchupMapper matchupMapper = new MatchupMapper();

	public MatchupServiceImpl(
			GameRepository gameRepository,
			BoxScoreRepository boxScoreRepository,
			BettingOddsRepository bettingOddsRepository,
			StatRepository statRepository,
			ForecastRepository forecastRepository) {
		this.gameRepository = gameRepository;
		this.boxScoreRepository = boxScoreRepository;
		this.bettingOddsRepository = bettingOddsRepository;
		this.statRepository = statRepository;
		this.forecastRepository = forecastRepository;
	}

	@Override
	@Transactional(readOnly = true)
	public List<MatchupDto> getMatchups(String league, Short season, Short week) {
		List<Game> games = resolveGames(league, season, week);
		return games.stream().map(this::toMatchup).toList();
	}

	private List<Game> resolveGames(String league, Short season, Short week) {
		if (league != null && season != null && week != null) {
			return gameRepository.findByLeagueAndSeasonAndWeek(league, season, week);
		}
		return gameRepository.findAll();
	}

	private MatchupDto toMatchup(Game game) {
		Team awayTeam = game.getAwayTeam();
		Team homeTeam = game.getHomeTeam();
		String gameId = game.getId();

		return matchupMapper.toDto(
			game,
			boxScoreRepository.findByGame_IdAndTeam_Id(gameId, awayTeam.getId()).orElse(null),
			bettingOddsRepository.findByGame_IdAndTeam_Id(gameId, awayTeam.getId()),
			statRepository.findByGame_IdAndTeam_Id(gameId, awayTeam.getId()),
			boxScoreRepository.findByGame_IdAndTeam_Id(gameId, homeTeam.getId()).orElse(null),
			bettingOddsRepository.findByGame_IdAndTeam_Id(gameId, homeTeam.getId()),
			statRepository.findByGame_IdAndTeam_Id(gameId, homeTeam.getId()),
			resolveForecast(game.getLocation(), game.getKickoffUtc())
		);
	}

	private Forecast resolveForecast(Location location, OffsetDateTime kickoffUtc) {
		return forecastRepository
			.findFirstByLocation_IdAndTimestampUtcLessThanEqualOrderByTimestampUtcDesc(
				location.getId(), kickoffUtc)
			.or(() -> forecastRepository.findFirstByLocation_IdOrderByTimestampUtcDesc(location.getId()))
			.orElse(null);
	}
	
}
