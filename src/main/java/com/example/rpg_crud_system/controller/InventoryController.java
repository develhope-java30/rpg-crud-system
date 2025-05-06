package com.example.rpg_crud_system.controller;

import com.example.rpg_crud_system.entity.Inventory;
import com.example.rpg_crud_system.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inventory")
public class InventoryController {
    @Autowired
    private InventoryService inventoryService;

    @GetMapping
    public List<Inventory> inventoryList(){
        return inventoryService.inventoryList();
    }

    @PostMapping
    public ResponseEntity<Inventory> createInventory(@RequestBody Inventory newInventory){
        return ResponseEntity.ok(inventoryService.createInventory(newInventory));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInventoryById(@PathVariable Long id){
        inventoryService.deleteInventoryById(id);
        return ResponseEntity.noContent().build();
    }

}
