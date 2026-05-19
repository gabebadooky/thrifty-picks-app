package com.thrifty.picks.bettingodds;

public class BettingOddsMapper {

	public BettingOddsDto toDto(BettingOdds bettingOdds) {
		return new BettingOddsDto(
			bettingOdds.getSource(),
			bettingOdds.getOverUnder(),
			bettingOdds.getMoneyline(),
			bettingOdds.getSpread(),
			bettingOdds.getWinProbability()
		);
	}
	
}
