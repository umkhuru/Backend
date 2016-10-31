package com.ramakhutla.ethan.services;

import com.ramakhutla.ethan.domain.Inventory;

import java.util.List;

/**
 * Created by Ethon on 2016/10/28.
 */
public interface InventoryService {

    Inventory addInventory(Inventory inv);
    Inventory updateInventory(Inventory inv);
    void removeInventory(Inventory inv);
    Inventory getInventory(long id);
    List<Inventory> getAllItems();
}
