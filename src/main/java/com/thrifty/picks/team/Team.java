package com.thrifty.picks.team;

import com.thrifty.picks.conference.Conference;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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
		name = "team",
		schema = "pickem",
		indexes = {
			@Index(name = "idx_team_conference", columnList = "conference"),
			@Index(name = "idx_team_ranking", columnList = "ranking")
		})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Team {

	@Id
	@Column(length = 100, nullable = false)
	private String id;

	@Column(length = 25, nullable = false)
	private String league;

	@Column(name = "espn_code", length = 50, nullable = false)
	private String espnCode;

	@Column(name = "cbs_code", length = 50, nullable = false)
	private String cbsCode;

	@Column(name = "fox_code", length = 50, nullable = false)
	private String foxCode;

	@Column(name = "vegas_code", length = 50)
	private String vegasCode;

	@ManyToOne(optional = false)
	@JoinColumn(name = "conference", nullable = false)
	private Conference conference;

	@Column(length = 50, nullable = false)
	private String division;

	@Column(length = 50, nullable = false)
	private String name;

	@Column(length = 50, nullable = false)
	private String mascot;

	@Column(name = "logo_url", length = 100, nullable = false)
	private String logoUrl;

	@Column(name = "dark_logo_url", length = 100, nullable = false)
	private String darkLogoUrl;

	@Column(name = "primary_color", length = 10, nullable = false)
	private String primaryColor;

	@Column(name = "alternate_color", length = 10, nullable = false)
	private String alternateColor;

	@Column(nullable = false)
	private short ranking;

	@UpdateTimestamp
	@Column(name = "updated_at", nullable = false)
	private OffsetDateTime updatedAt;
}
