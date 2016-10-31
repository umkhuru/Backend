package com.ramakhutla.ethan.conf.factories;

import com.ramakhutla.ethan.domain.InvoiceItems;

/**
 * Created by Ethon on 2016/10/28.
 */
public class InvoiceItemsFactory {

    public static InvoiceItems createInvoiceItems(int quantity)
    {
        InvoiceItems invoiceItems=new InvoiceItems.Builder(quantity)
                .build();
        return invoiceItems;
    }
}
