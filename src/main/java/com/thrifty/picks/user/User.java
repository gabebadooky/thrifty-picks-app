package com.thrifty.picks.user;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.Table;
import java.time.OffsetDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(
		name = "user",
		schema = "pickem",
		indexes = @Index(name = "idx_user_username", columnList = "username"))
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 75, nullable = false)
	private String username;

	@Column(name = "display_name", length = 50, nullable = false)
	private String displayName;

	@Column(name = "favorite_team", length = 100, nullable = false)
	private String favoriteTeam;

	@Column(name = "notification_preference", length = 1, nullable = false)
	private String notificationPreference;

	@Column(name = "email_address", length = 75, nullable = false)
	private String emailAddress;

	@Column(length = 10, nullable = false)
	private String phone;

	@CreationTimestamp
	@Column(name = "created_at", nullable = false)
	private OffsetDateTime createdAt;

	@UpdateTimestamp
	@Column(name = "updated_at", nullable = false)
	private OffsetDateTime updatedAt;
}
