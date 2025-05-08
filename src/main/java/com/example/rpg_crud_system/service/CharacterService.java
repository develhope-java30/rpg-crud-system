package com.example.rpg_crud_system.service;

import com.example.rpg_crud_system.entity.CharacterEntity;
import com.example.rpg_crud_system.repository.CharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CharacterService {

    @Autowired
    private CharacterRepository characterRepository;

    public CharacterEntity createCharacter(CharacterEntity characterEntity) {
        return characterRepository.save(characterEntity);
    }

    public List<CharacterEntity> getAll() {
        return characterRepository.findAll();
    }

    public Optional<CharacterEntity> getById(Long id) {
        return characterRepository.existsById(id) ? characterRepository.findById(id) : Optional.empty();
    }

    public Optional<CharacterEntity> updateCharacterLevel(Long id, Integer level) {
        Optional<CharacterEntity> characterEntityOptional = characterRepository.findById(id);

        if (characterEntityOptional.isPresent()) {
            characterEntityOptional.get().setLevel(level);
            return Optional.of(characterRepository.save(characterEntityOptional.get()));
        }

        return Optional.empty();
    }

    public void deleteCharacter(Long id) {
        characterRepository.deleteById(id);
    }
}
