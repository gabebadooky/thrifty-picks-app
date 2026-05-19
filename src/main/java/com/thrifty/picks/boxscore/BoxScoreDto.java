package com.thrifty.picks.boxscore;

public record BoxScoreDto(
	short quarter1,
	short quarter2,
	short quarter3,
	short quarter4,
	short overtime,
	short total
) {}
