package com.example.rpg_crud_system.service;

import com.example.rpg_crud_system.entity.CharacterStats;
import com.example.rpg_crud_system.repository.CharacterStatsRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CharacterStatsService {
    @Autowired
    private CharacterStatsRepository characterStatsRepository;

    public List<CharacterStats> getAllCharacterStats(){return characterStatsRepository.findAll();}
    public CharacterStats addCharacterStats(CharacterStats newCharacterStats) {return characterStatsRepository.save(newCharacterStats);}
}
