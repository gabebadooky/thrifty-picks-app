package com.thrifty.picks.prediction;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PredictionRepository extends JpaRepository<Prediction, PredictionId> {}
