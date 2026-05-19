package com.thrifty.picks.game;

public class GameMapper {

	public GameDto toDto(Game game) {
		return new GameDto(
			game.getId(),
			game.getLeague(),
			game.getWeek(),
			game.getSeason(),
			game.getEspnCode(),
			game.getCbsCode(),
			game.getFoxCode(),
			game.getVegasCode(),
			game.getKickoffUtc(),
			game.getBroadcast(),
			game.isFinished()
		);
	}

}
