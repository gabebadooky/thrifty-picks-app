package com.thrifty.picks.stat;

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
		name = "stat",
		schema = "pickem",
		indexes = @Index(name = "idx_stat_team", columnList = "team"))
@IdClass(StatId.class)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Stat {

	@Id
	@ManyToOne(optional = false)
	@JoinColumn(name = "game", nullable = false)
	private Game game;

	@Id
	@ManyToOne(optional = false)
	@JoinColumn(name = "team", nullable = false)
	private Team team;

	@Id
	@Column(name = "stat_type", length = 25, nullable = false)
	private String statType;

	private Float value;

	@UpdateTimestamp
	@Column(name = "updated_at", nullable = false)
	private OffsetDateTime updatedAt;
}
