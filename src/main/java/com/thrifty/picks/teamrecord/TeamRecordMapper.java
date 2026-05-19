package com.thrifty.picks.teamrecord;

public class TeamRecordMapper {

	public TeamRecordDto toDto(TeamRecord teamRecord) {
		return new TeamRecordDto(
			teamRecord.getRecordType(),
			teamRecord.getWins(),
			teamRecord.getLosses(),
			teamRecord.getTies()
		);
	}

}
