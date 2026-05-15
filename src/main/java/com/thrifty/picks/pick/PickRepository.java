package com.thrifty.picks.pick;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PickRepository extends JpaRepository<Pick, PickId> {}
