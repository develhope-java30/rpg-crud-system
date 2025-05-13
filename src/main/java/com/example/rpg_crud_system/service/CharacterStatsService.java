package com.example.rpg_crud_system.service;

import com.example.rpg_crud_system.entity.CharacterEntity;
import com.example.rpg_crud_system.entity.CharacterStats;
import com.example.rpg_crud_system.entity.ItemsEntity;
import com.example.rpg_crud_system.repository.CharacterStatsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CharacterStatsService {
    @Autowired
    private CharacterStatsRepository characterStatsRepository;

    public List<CharacterStats> getAllCharacterStats(){
        return characterStatsRepository.findAll();
    }

    public Optional<CharacterStats> getById(Long id) {
        return characterStatsRepository.existsById(id) ? characterStatsRepository.findById(id) : Optional.empty();
    }
    public CharacterStats addCharacterStats(CharacterStats newCharacterStats) {
        return characterStatsRepository.save(newCharacterStats);
    }
    public Optional<CharacterStats> findCharacterStatsById(Long id) {
        // recupero dell'oggetto optional
        Optional<CharacterStats> characterStatsOptional = characterStatsRepository.findById(id);
        if (characterStatsOptional.isPresent()){
            return characterStatsOptional;

        }else {
            return Optional.empty();
        }
    }

    public Optional<CharacterStats> updateCharacterStats(Long id, CharacterStats characterStatsToUpdate){
        if(characterStatsRepository.existsById(id)){
            characterStatsToUpdate.setId(id);
            return Optional.of(characterStatsRepository.save(characterStatsToUpdate));
        }
        return Optional.empty();
    }

    public void deleteCharacterStatsById(Long id){
        characterStatsRepository.deleteById(id);
    }


}
