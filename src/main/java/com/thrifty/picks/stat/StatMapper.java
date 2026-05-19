package com.thrifty.picks.stat;

public class StatMapper {

	public StatDto toDto(Stat stat) {
		return new StatDto(
			stat.getStatType(),
			stat.getValue()
		);
	}

}
