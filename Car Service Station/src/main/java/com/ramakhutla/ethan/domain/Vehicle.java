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
public class Vehicle implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String reg;
    private String model;

    public Vehicle() {
    }

    public Vehicle(Builder builder) {
        id=builder.id;
        reg=builder.reg;
        model=builder.model;
    }

    public static class Builder{
        private Long id;
        private String reg;
        private String model;

        public Builder(String reg)
        {
            this.reg=reg;
        }


        public Builder model(String value)
        {
            this.model=value;
            return this;
        }

        public Builder id(Long value)
        {
            this.id=value;
            return this;
        }

        public Builder copy(Vehicle value)
        {
            this.model=value.getModel();
            this.reg=value.getReg();
            this.id=value.getId();
            return this;
        }

        public Vehicle build()
        {
            return new Vehicle(this);
        }
    }

    public String getReg() {
        return reg;
    }

    public String getModel() {return model;}
    public Long getId() {return id;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Vehicle vehicle = (Vehicle) o;

        if (id != null ? !id.equals(vehicle.id) : vehicle.id != null) return false;
        if (reg != null ? !reg.equals(vehicle.reg) : vehicle.reg != null) return false;
        return model != null ? model.equals(vehicle.model) : vehicle.model == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (reg != null ? reg.hashCode() : 0);
        result = 31 * result + (model != null ? model.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "id=" + id +
                ", reg='" + reg + '\'' +
                ", model='" + model + '\'' +
                '}';
    }
}
