package com.thrifty.picks.conference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
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
		name = "conference",
		schema = "pickem",
		indexes = @Index(name = "idx_conference_power_conference", columnList = "power_conference"))
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Conference {

	@Id
	@Column(length = 25, nullable = false)
	private String id;

	@Column(length = 50, nullable = false)
	private String name;

	@Column(length = 10, nullable = false)
	private String abbreviation;

	@Column(name = "power_conference", nullable = false)
	private boolean powerConference;

	@UpdateTimestamp
	@Column(name = "updated_at", nullable = false)
	private OffsetDateTime updatedAt;
}
