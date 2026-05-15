package com.thrifty.picks.location;

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
@Table(name = "location", schema = "pickem")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Location {

	@Id
	@Column(length = 25, nullable = false)
	private String id;

	@Column(length = 100, nullable = false)
	private String stadium;

	@Column(length = 50, nullable = false)
	private String city;

	@Column(length = 25, nullable = false)
	private String state;

	@Column(nullable = false)
	private float latitude;

	@Column(nullable = false)
	private float longitude;

	@UpdateTimestamp
	@Column(name = "updated_at", nullable = false)
	private OffsetDateTime updatedAt;
}
