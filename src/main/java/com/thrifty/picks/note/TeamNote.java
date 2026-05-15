package com.thrifty.picks.note;

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
		name = "team_note",
		schema = "pickem",
		indexes = @Index(name = "idx_team_note_user", columnList = "user_id"))
@IdClass(TeamNoteId.class)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TeamNote {

	@Id
	@ManyToOne(optional = false)
	@JoinColumn(name = "user_id", nullable = false)
	private User user;

	@Id
	@ManyToOne(optional = false)
	@JoinColumn(name = "team", nullable = false)
	private Team team;

	@Column(columnDefinition = "TEXT")
	private String text;

	@UpdateTimestamp
	@Column(name = "updated_at", nullable = false)
	private OffsetDateTime updatedAt;
}
