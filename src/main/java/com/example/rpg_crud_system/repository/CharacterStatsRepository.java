package com.example.rpg_crud_system.repository;

import com.example.rpg_crud_system.entity.CharacterStats;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CharacterStatsRepository extends JpaRepository<CharacterStats, Long> {
}
