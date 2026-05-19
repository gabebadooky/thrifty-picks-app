package com.thrifty.picks.boxscore;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoxScoreRepository extends JpaRepository<BoxScore, BoxScoreId> {

	Optional<BoxScore> findByGame_IdAndTeam_Id(String gameId, String teamId);
	
}
