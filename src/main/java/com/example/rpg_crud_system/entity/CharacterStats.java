package com.example.rpg_crud_system.entity;

import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;

@Entity
public class CharacterStats {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer strength;
    private Integer dexterity;
    private Integer intelligence;
    private Integer wisdom;
    private Integer charisma;
    private Integer constitution;
    private LocalDate updated_at;

    @OneToOne
    private CharacterEntity characterEntity;

    private CharacterStats() {
    }

    public CharacterStats(Long id, Integer strength, Integer dexterity,
                          Integer intelligence, Integer wisdom, Integer charisma,
                          Integer constitution, LocalDate updated_at, CharacterEntity characterEntity) {
        this.id = id;
        this.strength = strength;
        this.dexterity = dexterity;
        this.intelligence = intelligence;
        this.wisdom = wisdom;
        this.charisma = charisma;
        this.constitution = constitution;
        this.updated_at = updated_at;
        this.characterEntity = characterEntity;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getStrength() {
        return strength;
    }

    public void setStrength(Integer strength) {
        this.strength = strength;
    }

    public Integer getDexterity() {
        return dexterity;
    }

    public void setDexterity(Integer dexterity) {
        this.dexterity = dexterity;
    }

    public Integer getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(Integer intelligence) {
        this.intelligence = intelligence;
    }

    public Integer getWisdom() {
        return wisdom;
    }

    public void setWisdom(Integer wisdom) {
        this.wisdom = wisdom;
    }

    public Integer getCharisma() {
        return charisma;
    }

    public void setCharisma(Integer charisma) {
        this.charisma = charisma;
    }

    public Integer getConstitution() {
        return constitution;
    }

    public void setConstitution(Integer constitution) {
        this.constitution = constitution;
    }

    public LocalDate getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(LocalDate updated_at) {
        this.updated_at = updated_at;
    }

    public CharacterEntity getCharacterEntity() {
        return characterEntity;
    }

    public void setCharacterEntity(CharacterEntity characterEntity) {
        this.characterEntity = characterEntity;
    }
}
