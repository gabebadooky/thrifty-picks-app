package com.thrifty.picks.prediction;

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
		name = "prediction",
		schema = "pickem",
		indexes = {
			@Index(name = "idx_prediction_user", columnList = "user_id"),
			@Index(name = "idx_prediction_code", columnList = "code")
		})
@IdClass(PredictionId.class)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Prediction {

	@Id
	@ManyToOne(optional = false)
	@JoinColumn(name = "user_id", nullable = false)
	private User user;

	@Id
	@Column(length = 25, nullable = false)
	private String code;

	@Column(length = 100)
	private String description;

	@Column(length = 100)
	private String selection;

	@UpdateTimestamp
	@Column(name = "updated_at", nullable = false)
	private OffsetDateTime updatedAt;
}
