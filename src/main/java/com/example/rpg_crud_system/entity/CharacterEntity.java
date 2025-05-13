package com.example.rpg_crud_system.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.UniqueElements;

import java.time.LocalDate;
import java.util.List;

@Entity
public class CharacterEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @UniqueElements
    private String name;

    @NotNull
    @Min(value = 1)
    @Max(value = 100)
    private Integer level;

    private String characterClass;

    @NotNull
    @Min(value = 0)
    private Integer experience;

    @NotNull
    @Min(value = 0)
    private Integer health;

    @NotNull
    @Min(value = 0)
    private Integer mana;
    private LocalDate created_at;
    private LocalDate updated_at;

    private CharacterEntity() {
    }

    public CharacterEntity(Long id, String name, Integer level, String characterClass,
                           Integer experience, Integer health, Integer mana,
                           LocalDate created_at, LocalDate updated_at) {
        this.id = id;
        this.name = name;
        this.level = level;
        this.characterClass = characterClass;
        this.experience = experience;
        this.health = health;
        this.mana = mana;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getCharacterClass() {
        return characterClass;
    }

    public void setCharacterClass(String characterClass) {
        this.characterClass = characterClass;
    }

    public Integer getExperience() {
        return experience;
    }

    public void setExperience(Integer experience) {
        this.experience = experience;
    }

    public Integer getHealth() {
        return health;
    }

    public void setHealth(Integer health) {
        this.health = health;
    }

    public Integer getMana() {
        return mana;
    }

    public void setMana(Integer mana) {
        this.mana = mana;
    }

    public LocalDate getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDate created_at) {
        this.created_at = created_at;
    }

    public LocalDate getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(LocalDate updated_at) {
        this.updated_at = updated_at;
    }
}
