package com.example.rpg_crud_system.controller;

import com.example.rpg_crud_system.entity.Inventory;
import com.example.rpg_crud_system.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/inventory")
public class InventoryController {
    @Autowired
    private InventoryService inventoryService;

    @GetMapping
    public List<Inventory> inventoryList(){
        return inventoryService.inventoryList();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Inventory> inventoryById(@PathVariable Long id){
        Optional<Inventory> foundInventory = inventoryService.inventoryById(id);

        return foundInventory
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());

    }

    @PostMapping
    public ResponseEntity<Inventory> createInventory(@RequestBody Inventory newInventory){
        return ResponseEntity.ok(inventoryService.createInventory(newInventory));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Inventory> updateInventory(@PathVariable Long id, @RequestBody Inventory inventoryToUpdate){
        Optional<Inventory> updatedInventory = inventoryService.inventoryUpdate(id, inventoryToUpdate);

        return updatedInventory
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.badRequest().build());

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInventoryById(@PathVariable Long id){
        inventoryService.deleteInventoryById(id);
        return ResponseEntity.noContent().build();
    }

}
