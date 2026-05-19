package com.thrifty.picks.conference;

public record ConferenceDto(
    String id,
    String name,
    String abbreviation,
    boolean powerConference
) {}
