package com.ramakhutla.ethan.services.impl;


import com.ramakhutla.ethan.domain.InvoiceItems;
import com.ramakhutla.ethan.repository.InvoiceItemsRepository;
import com.ramakhutla.ethan.services.InvoiceItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Ethon on 2016/10/28.
 */
@Service
public class InvoiceItemsServiceImpl implements InvoiceItemsService {

    @Autowired

    InvoiceItemsRepository repository;
    @Override
    public List<InvoiceItems> getInvoiceAllInvoiceItems() {
        List<InvoiceItems> allInvoiceItems=new ArrayList<>();
        Iterable<InvoiceItems> invoiceItems=repository.findAll();
        for(InvoiceItems items:invoiceItems)
        {
            allInvoiceItems.add(items);
        }
        return allInvoiceItems;
    }

    @Override
    public InvoiceItems getInvoiceItems(long id) {
        return repository.findOne(id);
    }

    @Override
    public InvoiceItems addInvoiceItems(InvoiceItems invoiceItems) {
        return repository.save(invoiceItems);
    }

    @Override
    public InvoiceItems updateInvoiceItems(InvoiceItems invoiceItems) {
        return repository.save(invoiceItems);
    }

    @Override
    public void removeInvoiceItems(long id) {
        repository.delete(id);
    }


}
