package com.thrifty.picks.bettingodds;

import com.thrifty.picks.game.Game;
import com.thrifty.picks.team.Team;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
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
		name = "betting_odds",
		schema = "pickem",
		indexes = @Index(name = "idx_betting_odds_team", columnList = "team"))
@IdClass(BettingOddsId.class)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BettingOdds {

	@Id
	@ManyToOne(optional = false)
	@JoinColumn(name = "game", nullable = false)
	private Game game;

	@Id
	@ManyToOne(optional = false)
	@JoinColumn(name = "team", nullable = false)
	private Team team;

	@Id
	@Column(length = 10, nullable = false)
	private String source;

	@Column(name = "over_under")
	private Float overUnder;

	private Short moneyline;

	private Float spread;

	@Column(name = "win_probability")
	private Float winProbability;

	@UpdateTimestamp
	@Column(name = "updated_at", nullable = false)
	private OffsetDateTime updatedAt;
}
