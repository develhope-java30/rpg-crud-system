package com.example.rpg_crud_system.repository;

import com.example.rpg_crud_system.entity.CharacterEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CharacterRepository extends JpaRepository<CharacterEntity, Long> {
}
