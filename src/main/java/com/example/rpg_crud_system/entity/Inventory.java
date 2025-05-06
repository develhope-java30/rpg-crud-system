package com.example.rpg_crud_system.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

//  SQL
//- id (PK)
//- character_id (FK) TODO
//- item_id (FK) TODO
//- quantity
//- slot_position
//- is_equipped

@Entity
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer quantity;
    private Integer slot_position;
    private boolean is_equipped;

    private Inventory(){}

    public Inventory(Long id, Integer quantity, Integer slot_position, boolean is_equipped) {
        this.id = id;
        this.quantity = quantity;
        this.slot_position = slot_position;
        this.is_equipped = is_equipped;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getSlot_position() {
        return slot_position;
    }

    public void setSlot_position(Integer slot_position) {
        this.slot_position = slot_position;
    }

    public boolean isIs_equipped() {
        return is_equipped;
    }

    public void setIs_equipped(boolean is_equipped) {
        this.is_equipped = is_equipped;
    }

}
