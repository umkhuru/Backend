package com.ramakhutla.ethan.servicetest;

import com.ramakhutla.ethan.App;
import com.ramakhutla.ethan.domain.Client;
import com.ramakhutla.ethan.domain.Invoice;
import com.ramakhutla.ethan.domain.InvoiceItems;
import com.ramakhutla.ethan.services.ClientService;
import com.ramakhutla.ethan.services.InvoiceItemsService;
import com.ramakhutla.ethan.services.InvoiceService;
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
public class InvoiceServiceTest extends AbstractTestNGSpringContextTests {

    @Autowired
    InvoiceService service;
    @Autowired
    InvoiceItemsService itemsService;

    @Autowired
    ClientService clientService;
    private Long id=2L;

    //    @Test
    public void create() throws Exception {
        Invoice invoice=new Invoice
                .Builder("21/04/2016")
                .build();
        service.addInvoice(invoice);
        id=invoice.getId();
        Assert.assertNotNull(id);
    }

    //    @Test
    public void read() throws Exception {
        Invoice invoice=service.getInvoice(id);
        Assert.assertNotNull(invoice);

    }

    //    @Test
    public void update() throws Exception {
        InvoiceItems items=itemsService.getInvoiceItems(id);
        InvoiceItems items2=itemsService.getInvoiceItems(3L);
        List<InvoiceItems> itemList=new ArrayList<>();
        itemList.add(items);
        itemList.add(items2);

        Invoice invoice=service.getInvoice(id);

        Invoice newInvoice=new Invoice
                .Builder(invoice.getDate())
                .copy(invoice)
                .invoiceItemsList(itemList)
                .build();
        List<Invoice> invList=new ArrayList<>();
        invList.add(newInvoice);

        Client client=clientService.getClient(id);
        Client updatedClient=new Client
                .Builder(client.getLastName())
                .copy(client)
                .invoices(invList)
                .build();

        clientService.updateClient(updatedClient);
        Assert.assertEquals(updatedClient.getInvoices(),invList);
    }


    //    @Test
    public void delete() throws Exception {
        Invoice invoice=service.getInvoice(id);
        service.removeInvoice(invoice);
        Invoice deletedInvoice=service.getInvoice(id);
        Assert.assertNull(deletedInvoice);
    }
}
