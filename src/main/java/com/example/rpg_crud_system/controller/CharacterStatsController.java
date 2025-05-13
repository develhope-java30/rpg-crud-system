package com.example.rpg_crud_system.controller;

import com.example.rpg_crud_system.entity.CharacterEntity;
import com.example.rpg_crud_system.entity.CharacterStats;
import com.example.rpg_crud_system.entity.Inventory;
import com.example.rpg_crud_system.entity.ItemsEntity;
import com.example.rpg_crud_system.service.CharacterStatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/CharacterStats")
public class CharacterStatsController {
    @Autowired
    private CharacterStatsService service;

    @GetMapping
    public List<CharacterStats> getAllCharacterStats() {
        return service.getAllCharacterStats();
    }

    @PostMapping
    public ResponseEntity<CharacterStats> addCharacterStats(@RequestBody CharacterStats newCharacterStats){
        return ResponseEntity.ok(service.addCharacterStats(newCharacterStats));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CharacterStats> getById(@PathVariable Long id) {
        return service.getById(id)
                .map(ResponseEntity::ok)
                .orElseGet(()->ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<CharacterStats> updateCharacterStats(@PathVariable Long id, @RequestBody CharacterStats characterStatsToUpdate){
        Optional<CharacterStats> updatedCharacterStats = service.updateCharacterStats(id, characterStatsToUpdate);

        return updatedCharacterStats
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.badRequest().build());

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCharacterStatsById(@PathVariable Long id){
        service.deleteCharacterStatsById(id);
        return ResponseEntity.noContent().build();
    }



}
