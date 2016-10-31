package com.ramakhutla.ethan.services;

import com.ramakhutla.ethan.domain.InvoiceItems;

import java.util.List;

/**
 * Created by Ethon on 2016/10/28.
 */
public interface InvoiceItemsService {

    List<InvoiceItems> getInvoiceAllInvoiceItems();
    InvoiceItems getInvoiceItems(long id);
    InvoiceItems addInvoiceItems(InvoiceItems invoiceItems);
    InvoiceItems updateInvoiceItems(InvoiceItems invoiceItems);
    void removeInvoiceItems(long id);
}
