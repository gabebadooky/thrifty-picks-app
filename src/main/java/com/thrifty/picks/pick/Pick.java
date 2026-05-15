package com.thrifty.picks.pick;

import com.thrifty.picks.game.Game;
import com.thrifty.picks.scoring.Scoring;
import com.thrifty.picks.team.Team;
import com.thrifty.picks.user.User;
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
		name = "pick",
		schema = "pickem",
		indexes = {
			@Index(name = "idx_pick_user", columnList = "user_id"),
			@Index(name = "idx_pick_team", columnList = "team")
		})
@IdClass(PickId.class)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Pick {

	@Id
	@ManyToOne(optional = false)
	@JoinColumn(name = "user_id", nullable = false)
	private User user;

	@Id
	@ManyToOne(optional = false)
	@JoinColumn(name = "game", nullable = false)
	private Game game;

	@ManyToOne
	@JoinColumn(name = "team")
	private Team team;

	@ManyToOne
	@JoinColumn(name = "confidence")
	private Scoring confidence;

	@UpdateTimestamp
	@Column(name = "updated_at", nullable = false)
	private OffsetDateTime updatedAt;
}
