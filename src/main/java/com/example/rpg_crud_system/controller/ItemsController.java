package com.example.rpg_crud_system.controller;

import com.example.rpg_crud_system.entity.ItemsEntity;
import com.example.rpg_crud_system.service.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/items")
public class ItemsController {
    @Autowired
    private ItemsService itemsService;

    @GetMapping
    public List<ItemsEntity> allItems(){
        return itemsService.allItems();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ItemsEntity> itemById(Long id){
        Optional<ItemsEntity> foundItem = itemsService.itemFindById(id);

        return foundItem
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());

    }

    @PostMapping
    public ResponseEntity<ItemsEntity> addItems(@RequestBody ItemsEntity newItem){
        return ResponseEntity.ok(itemsService.addItems(newItem));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ItemsEntity> updateItem(@PathVariable Long id, @RequestBody ItemsEntity itemToUpdate){
        Optional<ItemsEntity> itemUpdated = itemsService.updateItem(id, itemToUpdate);

        return itemUpdated
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.badRequest().build());

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> itemDeleteById(@PathVariable Long id){
        itemsService.deleteItems(id);
        return ResponseEntity.noContent().build();
    }

}
