package com.thrifty.picks.bettingodds;

public record BettingOddsDto(
	String source,
	Float overUnder, 
	Short moneyline,
	Float spread,
	Float winProbability
) {}
