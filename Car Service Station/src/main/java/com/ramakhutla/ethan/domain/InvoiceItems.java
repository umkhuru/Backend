package com.ramakhutla.ethan.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by Ethon on 2016/10/28.
 */
@Entity
public class InvoiceItems implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int quantity;

    public InvoiceItems() {
    }
    public InvoiceItems(Builder builder) {
        this.id=builder.id;
        this.quantity=builder.quantity;
    }

    public static class Builder{
        private int quantity;
        private Long id;

        public Builder(int quantity)
        {
            this.quantity=quantity;
        }


        public Builder copy(InvoiceItems value)
        {
            this.quantity=value.quantity;
            this.id=value.id;
            return this;
        }

        public InvoiceItems build()
        {
            return new InvoiceItems(this);
        }
    }

    public Long getId() {
        return id;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        InvoiceItems that = (InvoiceItems) o;

        if (quantity != that.quantity) return false;
        return id != null ? id.equals(that.id) : that.id == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + quantity;
        return result;
    }

    @Override
    public String toString() {
        return "InvoiceItems{" +
                "id=" + id +
                ", quantity=" + quantity +
                '}';
    }
}
