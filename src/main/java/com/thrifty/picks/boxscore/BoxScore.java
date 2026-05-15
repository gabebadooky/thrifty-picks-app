package com.thrifty.picks.boxscore;

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
		name = "box_score",
		schema = "pickem",
		indexes = @Index(name = "idx_box_score_team", columnList = "team"))
@IdClass(BoxScoreId.class)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BoxScore {

	@Id
	@ManyToOne(optional = false)
	@JoinColumn(name = "game", nullable = false)
	private Game game;

	@Id
	@ManyToOne(optional = false)
	@JoinColumn(name = "team", nullable = false)
	private Team team;

	private Short quarter1;

	private Short quarter2;

	private Short quarter3;

	private Short quarter4;

	private Short overtime;

	private Short total;

	@UpdateTimestamp
	@Column(name = "updated_at", nullable = false)
	private OffsetDateTime updatedAt;
}
