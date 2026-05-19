package com.thrifty.picks.boxscore;

public class BoxScoreMapper {

	public BoxScoreDto toDto(BoxScore boxScore) {
		return new BoxScoreDto(
			boxScore.getQuarter1(),
			boxScore.getQuarter2(),
			boxScore.getQuarter3(),
			boxScore.getQuarter4(),
			boxScore.getOvertime(),
			boxScore.getTotal()
		);
	}

}
