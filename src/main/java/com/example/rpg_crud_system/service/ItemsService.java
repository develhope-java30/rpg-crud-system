package com.example.rpg_crud_system.service;

import com.example.rpg_crud_system.entity.ItemsEntity;
import com.example.rpg_crud_system.repository.ItemsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemsService {
    @Autowired
    private ItemsRepository itemsRepository;

    public List<ItemsEntity> allItems(){
        return itemsRepository.findAll();
    }

    public Optional<ItemsEntity> itemFindById(Long id){
        return itemsRepository.findById(id);
    }

    public Optional<ItemsEntity> updateItem(Long id, ItemsEntity itemToUpdate){
        if(itemsRepository.existsById(id)){
            itemToUpdate.setId(id);
            return Optional.of(itemsRepository.save(itemToUpdate));
        }
        return Optional.empty();
    }

    public ItemsEntity addItems(ItemsEntity newItem){
        return itemsRepository.save(newItem);
    }

    public void deleteItems(Long id){
        itemsRepository.deleteById(id);
    }
}
