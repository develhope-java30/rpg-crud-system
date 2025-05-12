package com.example.rpg_crud_system.controller;

import com.example.rpg_crud_system.entity.CharacterEntity;
import com.example.rpg_crud_system.service.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/characters")
public class CharacterController {

    @Autowired
    private CharacterService characterService;

    @PostMapping
    public CharacterEntity createCharacter(@RequestBody CharacterEntity characterEntity) {
        return characterService.createCharacter(characterEntity);
    }

    @GetMapping
    public List<CharacterEntity> getAll() {
        return characterService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CharacterEntity> getById(@PathVariable Long id) {
        return characterService.getById(id)
                .map(ResponseEntity::ok)
                .orElseGet(()->ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}/level")
    public ResponseEntity<CharacterEntity> updateCharacterLevel(@PathVariable Long id, @RequestParam Integer level) {
        return characterService.updateCharacterLevel(id, level)
                .map(ResponseEntity::ok)
                .orElseGet(()-> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCharacterById (@PathVariable Long id) {
        characterService.deleteCharacter(id);
    }

}
