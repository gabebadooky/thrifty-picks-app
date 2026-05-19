package com.thrifty.picks.teamrecord;

public record TeamRecordDto(
    String recordType,
    short wins,
    short losses,
    short ties
) {}
