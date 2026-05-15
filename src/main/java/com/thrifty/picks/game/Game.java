package com.thrifty.picks.game;

import com.thrifty.picks.location.Location;
import com.thrifty.picks.team.Team;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.OffsetDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(
		name = "game",
		schema = "pickem",
		indexes = {
			@Index(name = "idx_game_week", columnList = "week"),
			@Index(name = "idx_game_away_team", columnList = "away_team"),
			@Index(name = "idx_game_home_team", columnList = "home_team"),
			@Index(name = "idx_game_finished", columnList = "finished")
		})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Game {

	@Id
	@Column(length = 100, nullable = false)
	private String id;

	@Column(length = 25, nullable = false)
	private String league;

	@Column(nullable = false)
	private short week;

	@Column(nullable = false)
	private short season;

	@Column(name = "espn_code", length = 50, nullable = false)
	private String espnCode;

	@Column(name = "cbs_code", length = 50, nullable = false)
	private String cbsCode;

	@Column(name = "fox_code", length = 50, nullable = false)
	private String foxCode;

	@Column(name = "vegas_code", length = 50)
	private String vegasCode;

	@ManyToOne(optional = false)
	@JoinColumn(name = "away_team", nullable = false)
	private Team awayTeam;

	@ManyToOne(optional = false)
	@JoinColumn(name = "home_team", nullable = false)
	private Team homeTeam;

	@Column(name = "kickoff_utc", nullable = false)
	private OffsetDateTime kickoffUtc;

	@Column(length = 25, nullable = false)
	private String broadcast;

	@ManyToOne(optional = false)
	@JoinColumn(name = "location", nullable = false)
	private Location location;

	@Column(nullable = false)
	private boolean finished;

	@UpdateTimestamp
	@Column(name = "updated_at", nullable = false)
	private OffsetDateTime updatedAt;
}
