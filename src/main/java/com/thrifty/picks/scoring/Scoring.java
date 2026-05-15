package com.thrifty.picks.scoring;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.OffsetDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "scoring", schema = "pickem")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Scoring {

	@Id
	@Column(length = 1, nullable = false)
	private String confidence;

	@Column(nullable = false)
	private short reward;

	@Column(nullable = false)
	private short penalty;

	@UpdateTimestamp
	@Column(name = "updated_at", nullable = false)
	private OffsetDateTime updatedAt;
}
