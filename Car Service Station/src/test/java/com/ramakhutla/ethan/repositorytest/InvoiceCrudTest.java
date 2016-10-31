package com.ramakhutla.ethan.repositorytest;

import com.ramakhutla.ethan.App;
import com.ramakhutla.ethan.domain.Client;
import com.ramakhutla.ethan.domain.Invoice;
import com.ramakhutla.ethan.domain.InvoiceItems;
import com.ramakhutla.ethan.repository.ClientRepository;
import com.ramakhutla.ethan.repository.InvoiceItemsRepository;
import com.ramakhutla.ethan.repository.InvoiceRepository;
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
public class InvoiceCrudTest extends AbstractTestNGSpringContextTests {

    @Autowired
    InvoiceRepository repostiory;
    @Autowired
    ClientRepository clientRepostiory;
    @Autowired

    InvoiceItemsRepository itemsRepository;
    private Long id=(long)1;

    // @Test
    public void create() throws Exception
    {
        Invoice invoice=new Invoice
                .Builder("21/04/2016")
                .build();
        repostiory.save(invoice);
        id=invoice.getId();
        Assert.assertNotNull(id);
    }

    // @Test
    public void read() throws Exception
    {
        Invoice invoice=repostiory.findOne(id);
        Assert.assertNotNull(invoice);

    }

    // @Test
    public void update() throws Exception
    {

        InvoiceItems items=itemsRepository.findOne(1L);
        List<InvoiceItems> itemList=new ArrayList<>();
        itemList.add(items);

        Invoice invoice=repostiory.findOne(id);
        Invoice newInvoice=new Invoice
                .Builder(invoice.getDate())
                .copy(invoice)
                .invoiceItemsList(itemList)
                .build();
        List<Invoice> invList=new ArrayList<>();
        invList.add(newInvoice);

        //Giving this Invoice to a certain client...
        Client client=clientRepostiory.findOne((long)1);
        Client updatedClient=new Client
                .Builder(client.getLastName())
                .copy(client)
                .invoices(invList)
                .build();

        clientRepostiory.save(updatedClient);
        Assert.assertNotNull(updatedClient.getInvoices());
    }

    // @Test
    public void delete() throws Exception
    {
        Invoice invoice=repostiory.findOne(id);
        repostiory.delete(invoice);

        Invoice deletedInvoice=repostiory.findOne(id);
        Assert.assertNull(deletedInvoice);
    }
}
