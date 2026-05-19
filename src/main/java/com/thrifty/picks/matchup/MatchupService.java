package com.thrifty.picks.matchup;

import java.util.List;

public interface MatchupService {

	List<MatchupDto> getMatchups(String league, Short season, Short week);
	
}
