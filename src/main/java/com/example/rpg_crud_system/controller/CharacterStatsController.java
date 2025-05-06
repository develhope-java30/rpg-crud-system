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
    private CharacterStatsService characterStatsService;

    @GetMapping
    public List<CharacterStats> getAllCharacterStats() {return getAllCharacterStats(); }

    @PostMapping
    public ResponseEntity<CharacterStats> addCharacterStats(@RequestBody CharacterStats newCharacterStats){
        return ResponseEntity.ok(characterStatsService.addCharacterStats(newCharacterStats));
    }


}
