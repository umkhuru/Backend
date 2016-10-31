package com.ramakhutla.ethan.servicetest;

import com.ramakhutla.ethan.App;
import com.ramakhutla.ethan.domain.Inventory;
import com.ramakhutla.ethan.domain.InvoiceItems;
import com.ramakhutla.ethan.services.InventoryService;
import com.ramakhutla.ethan.services.InvoiceItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ethon on 2016/10/28.
 */
@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class InvoiceItemsServiceTest extends AbstractTestNGSpringContextTests {

    @Autowired
    InvoiceItemsService service;

    @Autowired
    InventoryService inventoryService;
    private Long id=2L;
    //    @Test
    public void create() throws Exception {
        InvoiceItems invoiceItems=new InvoiceItems
                .Builder(2)
                .build();
        service.addInvoiceItems(invoiceItems);
        id=invoiceItems.getId();
        Assert.assertNotNull(id);

    }

    //    @Test
    public void read() throws Exception {
        InvoiceItems invoiceItems=service.getInvoiceItems(id);
        Assert.assertNotNull(invoiceItems);
    }


    //    @Test
    public void update() throws Exception {
        InvoiceItems invoiceItems=service.getInvoiceItems(3L);
        List<InvoiceItems> invoiceItemsList=new ArrayList<>();

        invoiceItemsList.add(invoiceItems);

        Inventory inv=inventoryService.getInventory(1L);//get the item with the id=1
        Inventory inventory=new Inventory
                .Builder(inv.getDescription())
                .copy(inv)
                .invoiceItemsList(invoiceItemsList)
                .build();
        inventoryService.updateInventory(inventory);

        Assert.assertEquals(inventory.getInvoiceItemsList(),invoiceItemsList);
    }


    //    @Test
    public void delete() throws Exception {
        InvoiceItems invoiceItems=service.getInvoiceItems(id);
        service.removeInvoiceItems(invoiceItems.getId());
        InvoiceItems deletedInvoiceItems=service.getInvoiceItems(id);
        Assert.assertNull(invoiceItems);
    }
}
