package com.thrifty.picks.bettingodds;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BettingOddsRepository extends JpaRepository<BettingOdds, BettingOddsId> {

	List<BettingOdds> findByGame_IdAndTeam_Id(String gameId, String teamId);
	
}
