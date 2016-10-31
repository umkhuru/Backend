package com.ramakhutla.ethan.services;

import com.ramakhutla.ethan.domain.Invoice;
import com.ramakhutla.ethan.domain.InvoiceItems;

import java.util.List;

/**
 * Created by Ethon on 2016/10/28.
 */
public interface InvoiceService {

    List<InvoiceItems> getItems(long id);
    Invoice getInvoice(long id);
    Invoice addInvoice(Invoice inv);
    void removeInvoice(Invoice invoice);
    Invoice updateInvoice(Invoice inv);
    List<Invoice> getInvoices();
}
