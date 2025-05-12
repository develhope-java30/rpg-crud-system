package com.example.rpg_crud_system.controller;

import com.example.rpg_crud_system.entity.CharacterStats;
import com.example.rpg_crud_system.service.CharacterStatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCharacterStatsById(@PathVariable Long id){
        service.deleteCharacterStatsById(id);
        return ResponseEntity.noContent().build();
    }



}
