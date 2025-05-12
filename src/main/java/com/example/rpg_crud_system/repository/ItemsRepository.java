package com.example.rpg_crud_system.repository;

import com.example.rpg_crud_system.entity.ItemsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemsRepository extends JpaRepository<ItemsEntity, Long> {
}
