package com.ramakhutla.ethan.repositorytest;

import com.ramakhutla.ethan.App;
import com.ramakhutla.ethan.domain.Inventory;
import com.ramakhutla.ethan.domain.InvoiceItems;
import com.ramakhutla.ethan.repository.InventoryRepository;
import com.ramakhutla.ethan.repository.InvoiceItemsRepository;
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
public class InvoiceItemsCrudTest extends AbstractTestNGSpringContextTests {

    @Autowired

    InvoiceItemsRepository repository;
    @Autowired
    InventoryRepository inventoryRepository;

    private Long id=(long)1;

    // @Test
    public void create() throws Exception
    {
        InvoiceItems invoiceItems=new InvoiceItems
                .Builder(4)
                .build();
        repository.save(invoiceItems);
        Assert.assertNotNull(id);
    }

    // @Test
    public void read() throws Exception
    {
        InvoiceItems invoiceItems=repository.findOne(id);
        Assert.assertNotNull(invoiceItems);
    }

    // @Test
    public void update() throws Exception
    {

        Inventory brakes=inventoryRepository.findOne((long)1);

        InvoiceItems invoiceItems=repository.findOne(id);
        List<InvoiceItems> invoiceItemsList=new ArrayList<>();
        invoiceItemsList.add(invoiceItems);

        Inventory updatedInventory=new Inventory
                .Builder(brakes.getDescription())
                .copy(brakes)
                .invoiceItemsList(invoiceItemsList)
                .stock(brakes.getStock()-invoiceItems.getQuantity())
                .build();
        inventoryRepository.save(updatedInventory);
        Assert.assertEquals(updatedInventory.getStock(),16);

    }

    // @Test
    public void delete() throws Exception
    {
        InvoiceItems invoiceItems=repository.findOne(id);
        repository.delete(invoiceItems);

        InvoiceItems deletedInvoiceItems=repository.findOne(id);
        Assert.assertNull(deletedInvoiceItems);
    }
}
