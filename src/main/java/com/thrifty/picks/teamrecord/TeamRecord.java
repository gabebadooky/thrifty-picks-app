package com.thrifty.picks.teamrecord;

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
		name = "team_record",
		schema = "pickem",
		indexes = @Index(name = "idx_team_record_team", columnList = "team"))
@IdClass(TeamRecordId.class)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TeamRecord {

	@Id
	@ManyToOne(optional = false)
	@JoinColumn(name = "team", nullable = false)
	private Team team;

	@Id
	@Column(name = "record_type", length = 10, nullable = false)
	private String recordType;

	private short wins;

	private short losses;

	private short ties;

	@UpdateTimestamp
	@Column(name = "updated_at", nullable = false)
	private OffsetDateTime updatedAt;
}
