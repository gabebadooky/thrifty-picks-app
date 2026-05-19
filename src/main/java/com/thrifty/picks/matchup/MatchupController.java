package com.thrifty.picks.matchup;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/matchups")
public class MatchupController {

	private final MatchupService matchupService;

	public MatchupController(MatchupService matchupService) {
		this.matchupService = matchupService;
	}

	@GetMapping
	public List<MatchupDto> getMatchups(
			@RequestParam(required = false) String league,
			@RequestParam(required = false) Short season,
			@RequestParam(required = false) Short week) {
		return matchupService.getMatchups(league, season, week);
	}
	
}
