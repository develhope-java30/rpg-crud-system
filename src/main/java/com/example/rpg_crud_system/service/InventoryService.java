package com.example.rpg_crud_system.service;

import com.example.rpg_crud_system.entity.Inventory;
import com.example.rpg_crud_system.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//  GET    /api/characters/{id}/inventory
//  POST   /api/characters/{id}/inventory
//  PUT    /api/characters/{id}/inventory/{itemId}
//  DELETE /api/characters/{id}/inventory/{itemId}

@Service
public class InventoryService {
    @Autowired
    private InventoryRepository inventoryRepository;

    public List<Inventory> inventoryList(){
        return inventoryRepository.findAll();
    }

    public Inventory addInventory(Inventory newInventory){
        return inventoryRepository.save(newInventory);
    }

    public void deleteInventoryById(Long id){
        inventoryRepository.deleteById(id);
    }

}
