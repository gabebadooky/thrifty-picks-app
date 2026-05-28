package com.thrifty.picks.debug;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.core.env.ConfigurableEnvironment;

public class DebugDialectEnvironmentPostProcessor implements EnvironmentPostProcessor {

	private static final Path LOG_PATH = Path.of(
			"/Users/gbaduqui/projects/thrifty-picks/thrifty-picks-app/.cursor/debug-9c1b3e.log");

	@Override
	public void postProcessEnvironment(ConfigurableEnvironment environment, SpringApplication application) {
		// #region agent log
		String dialect = environment.getProperty("spring.jpa.properties.hibernate.dialect");
		String trimmed = dialect == null ? null : dialect.trim();
		String payload = "{\"sessionId\":\"9c1b3e\",\"runId\":\"pre-fix\",\"hypothesisId\":\"A\",\"location\":\"DebugDialectEnvironmentPostProcessor\",\"message\":\"resolved hibernate dialect\",\"data\":{\"dialectLength\":"
				+ (dialect == null ? "null" : dialect.length())
				+ ",\"trimmedLength\":" + (trimmed == null ? "null" : trimmed.length())
				+ ",\"hasTrailingWhitespace\":" + (dialect != null && !dialect.equals(trimmed))
				+ ",\"dialectEndsWithSpace\":" + (dialect != null && dialect.endsWith(" "))
				+ "},\"timestamp\":" + System.currentTimeMillis() + "}\n";
		try {
			Files.createDirectories(LOG_PATH.getParent());
			Files.writeString(LOG_PATH, payload, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
		} catch (Exception ignored) {
		}
		// #endregion

		// #region agent log
		String driver = environment.getProperty("spring.datasource.driver-class-name");
		String urlSet = environment.getProperty("spring.datasource.url") != null ? "yes" : "no";
		String payloadB = "{\"sessionId\":\"9c1b3e\",\"runId\":\"pre-fix\",\"hypothesisId\":\"B\",\"location\":\"DebugDialectEnvironmentPostProcessor\",\"message\":\"datasource env\",\"data\":{\"driverClass\":"
				+ (driver == null ? "null" : "\"" + driver + "\"")
				+ ",\"urlConfigured\":\"" + urlSet
				+ "\"},\"timestamp\":" + System.currentTimeMillis() + "}\n";
		try {
			Files.writeString(LOG_PATH, payloadB, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
		} catch (Exception ignored) {
		}
		// #endregion

		// #region agent log
		boolean dialectInEnv = environment.containsProperty("spring.jpa.properties.hibernate.dialect");
		String payloadC = "{\"sessionId\":\"9c1b3e\",\"runId\":\"pre-fix\",\"hypothesisId\":\"C\",\"location\":\"DebugDialectEnvironmentPostProcessor\",\"message\":\"dialect property source\",\"data\":{\"explicitDialectProperty\":"
				+ dialectInEnv + "},\"timestamp\":" + System.currentTimeMillis() + "}\n";
		try {
			Files.writeString(LOG_PATH, payloadC, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
		} catch (Exception ignored) {
		}
		// #endregion
	}
}
