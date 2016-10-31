package com.ramakhutla.ethan.services.impl;

import com.ramakhutla.ethan.domain.Inventory;
import com.ramakhutla.ethan.repository.InventoryRepository;
import com.ramakhutla.ethan.services.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ethon on 2016/10/28.
 */
@Service
public class InventoryServiceImpl implements InventoryService {

    @Autowired
    InventoryRepository repository;

    @Override
    public Inventory addInventory(Inventory inv) {
        return repository.save(inv);
    }

    @Override
    public Inventory updateInventory(Inventory inv) {
        return repository.save(inv);
    }

    @Override
    public void removeInventory(Inventory inv) {
        repository.delete(inv);
    }

    @Override
    public Inventory getInventory(long id) {
        return repository.findOne(id);
    }

    @Override
    public List<Inventory> getAllItems() {
        List<Inventory> allInventory=new ArrayList<>();
        Iterable<Inventory> items=repository.findAll();

        for(Inventory inv:items)
        {
            allInventory.add(inv);
        }

        return allInventory;
    }
}
