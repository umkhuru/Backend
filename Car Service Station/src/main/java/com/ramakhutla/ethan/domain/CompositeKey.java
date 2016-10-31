package com.ramakhutla.ethan.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Map;

/**
 * Created by Ethon on 2016/10/28.
 */
@Embeddable
public class CompositeKey implements Serializable {

    @Column
    private Long invoiceID;
    @Column
    private Long itemID;

    public CompositeKey() {
    }

    public CompositeKey(Builder builder) {
        this.invoiceID=builder.invoiceID;
        this.itemID=builder.itemID;
    }

    public static class Builder{
        private Long invoiceID;
        private Long itemID;

        public Builder(Map<String,Long> values)
        {
            this.invoiceID=values.get("invoiceID");
            this.itemID=values.get("itemID");
        }

        public Builder copy(CompositeKey value)
        {
            this.itemID=value.itemID;
            this.invoiceID=value.invoiceID;
            return this;
        }

        public CompositeKey build()
        {
            return new CompositeKey(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CompositeKey that = (CompositeKey) o;

        if (invoiceID != null ? !invoiceID.equals(that.invoiceID) : that.invoiceID != null) return false;
        return itemID != null ? itemID.equals(that.itemID) : that.itemID == null;

    }

    @Override
    public int hashCode() {
        int result = invoiceID != null ? invoiceID.hashCode() : 0;
        result = 31 * result + (itemID != null ? itemID.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "CompositeKey{" +
                "invoiceID=" + invoiceID +
                ", itemID=" + itemID +
                '}';
    }

    public Long getInvoiceID() {
        return invoiceID;
    }

    public Long getItemID() {
        return itemID;
    }
}
