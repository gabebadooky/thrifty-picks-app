package com.thrifty.picks.game;

import java.util.List;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, String> {

	@Override
	@EntityGraph(attributePaths = {"awayTeam", "awayTeam.conference", "homeTeam", "homeTeam.conference", "location"})
	List<Game> findAll();

	@EntityGraph(attributePaths = {"awayTeam", "awayTeam.conference", "homeTeam", "homeTeam.conference", "location"})
	List<Game> findByLeagueAndSeasonAndWeek(String league, short season, short week);
	
}
