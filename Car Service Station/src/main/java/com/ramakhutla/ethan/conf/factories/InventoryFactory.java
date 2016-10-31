package com.ramakhutla.ethan.conf.factories;

import com.ramakhutla.ethan.domain.Inventory;

/**
 * Created by Ethon on 2016/10/28.
 */
public class InventoryFactory {

    public static Inventory createInventory(String desc,double price,int stock)
    {
        Inventory inventory=new Inventory.Builder(desc)
                .price(price)
                .stock(stock)
                .build();
        return inventory;
    }
}
