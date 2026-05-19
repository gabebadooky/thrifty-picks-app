package com.thrifty.picks.team;

public class TeamMapper {

	public TeamDto toDto(Team team) {
		return new TeamDto(
			team.getLeague(),
			team.getEspnCode(),
			team.getCbsCode(),
			team.getFoxCode(),
			team.getVegasCode(),
			team.getDivision(),
			team.getName(),
			team.getMascot(),
			team.getLogoUrl(),
			team.getDarkLogoUrl(),
			team.getPrimaryColor(),
			team.getAlternateColor(),
			team.getRanking()
		);
	}

}
