package com.thrifty.picks.stat;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatRepository extends JpaRepository<Stat, StatId> {

	List<Stat> findByGame_IdAndTeam_Id(String gameId, String teamId);
	
}
