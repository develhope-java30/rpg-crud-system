package com.example.rpg_crud_system.entity;

import com.example.rpg_crud_system.entity.enumerated.ItemsTypes;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.UniqueElements;

//  Nome univoco
//  Tipo valido
//  Requisiti di livello validi
//  Statistiche non negative

@Entity
public class ItemsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @UniqueElements
    private String name;

    @NotNull
    @Enumerated(EnumType.STRING)
    private ItemsTypes type;

    private String rarity;

    @Min(0)
    @Max(100)
    private Integer level_requirement;

    private String description;

    private ItemsEntity(){}

    public ItemsEntity(Long id, String name, ItemsTypes type, String rarity, Integer level_requirement, String description) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.rarity = rarity;
        this.level_requirement = level_requirement;
        this.description = description;
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

    public ItemsTypes getType() {
        return type;
    }

    public void setType(ItemsTypes type) {
        this.type = type;
    }

    public String getRarity() {
        return rarity;
    }

    public void setRarity(String rarity) {
        this.rarity = rarity;
    }

    public Integer getLevel_requirement() {
        return level_requirement;
    }

    public void setLevel_requirement(Integer level_requirement) {
        this.level_requirement = level_requirement;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
