package com.ramakhutla.ethan.conf.factories;

import com.ramakhutla.ethan.domain.Invoice;
import com.ramakhutla.ethan.domain.InvoiceItems;
import com.ramakhutla.ethan.domain.Job;

import java.util.List;

/**
 * Created by Ethon on 2016/10/28.
 */
public class InvoiceFactory {

    public static Invoice createInvoice(String date, List<Job> jobList, List<InvoiceItems> invoiceItems)
    {
        Invoice invoice=new Invoice.Builder(date)
                .build();
        return invoice;
    }
}
