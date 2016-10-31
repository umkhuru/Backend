package com.ramakhutla.ethan.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Ethon on 2016/10/28.
 */
@Entity
public class Invoice implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String date;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="Invoice_id")
    private List<InvoiceItems> invoiceItemsList;


    public Invoice() {
    }

    public Invoice(Builder builder) {
        this.id=builder.id;
        this.date=builder.date;
        this.invoiceItemsList=builder.invoiceItemsList;
    }

    public static class Builder{
        private Long id;
        private String date;
        private List<InvoiceItems> invoiceItemsList;

        public Builder(String date)
        {
            this.date=date;
        }

        public Builder invoiceItemsList(List<InvoiceItems> list)
        {
            this.invoiceItemsList=list;
            return this;
        }

        public Builder id(Long id)
        {
            this.id=id;
            return this;
        }


        public Builder copy(Invoice value)
        {
            this.date=value.date;
            this.id=value.id;
            this.invoiceItemsList=value.invoiceItemsList;
            return this;
        }

        public Invoice build()
        {
            return new Invoice(this);
        }
    }

    public Long getId() {
        return id;
    }

    public String getDate() {
        return date;
    }

    public List<InvoiceItems> getInvoiceItemsList() {
        return invoiceItemsList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Invoice invoice = (Invoice) o;

        if (id != null ? !id.equals(invoice.id) : invoice.id != null) return false;
        if (date != null ? !date.equals(invoice.date) : invoice.date != null) return false;
        return invoiceItemsList != null ? invoiceItemsList.equals(invoice.invoiceItemsList) : invoice.invoiceItemsList == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (invoiceItemsList != null ? invoiceItemsList.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "id=" + id +
                ", date='" + date + '\'' +
                ", invoiceItemsList=" + invoiceItemsList +
                '}';
    }
}
