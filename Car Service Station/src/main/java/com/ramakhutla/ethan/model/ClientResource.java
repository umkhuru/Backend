package com.ramakhutla.ethan.model;

import com.ramakhutla.ethan.domain.ContactDetails;
import com.ramakhutla.ethan.domain.Vehicle;
import org.springframework.hateoas.ResourceSupport;

import java.util.List;

/**
 * Created by Ethon on 2016/10/28.
 */
public class ClientResource extends ResourceSupport {

    private Long resid;
    private String firstName;
    private String lastName;
    private int age;

    private ContactDetails address;
    private List<Vehicle> vehicle;

    public ClientResource() {
    }

    public ClientResource(Builder builder) {
        resid=builder.resid;
        firstName=builder.firstName;
        lastName=builder.lastName;
        vehicle=builder.vehicle;
        address=builder.address;
        age=builder.age;
    }

    public static class Builder{
        private Long resid;
        private String firstName;
        private String lastName;
        private List<Vehicle> vehicle;
        private ContactDetails address;
        private int age;

        public Builder(String lastName)
        {
            this.lastName=lastName;
        }

        public Builder firstName(String value)
        {
            this.firstName=value;
            return this;
        }


        public Builder resid(Long value)
        {
            this.resid=value;
            return this;
        }

        public Builder vehicle(List<Vehicle> value)
        {
            this.vehicle=value;
            return this;
        }

        public Builder address(ContactDetails address)
        {
            this.address=address;
            return this;
        }

        public Builder age(int age)
        {
            this.age=age;
            return this;
        }

        public Builder copy(ClientResource value)
        {
            this.resid=value.getResidId();
            this.firstName=value.getFirstName();
            this.lastName=value.getLastName();
            this.vehicle=value.getVehicle();
            this.address=value.getAddress();
            this.age=value.getAge();

            return this;
        }

        public ClientResource build(){
            return new ClientResource(this);
        }

    }

    public int getAge(){return age;}

    public Long getResidId() {
        return resid;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public ContactDetails getAddress() {
        return address;
    }

    public List<Vehicle> getVehicle() {
        return vehicle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        ClientResource that = (ClientResource) o;

        if (age != that.age) return false;
        if (resid != null ? !resid.equals(that.resid) : that.resid != null) return false;
        if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null) return false;
        if (lastName != null ? !lastName.equals(that.lastName) : that.lastName != null) return false;
        if (address != null ? !address.equals(that.address) : that.address != null) return false;
        return vehicle != null ? vehicle.equals(that.vehicle) : that.vehicle == null;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (resid != null ? resid.hashCode() : 0);
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + age;
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (vehicle != null ? vehicle.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ClientResource{" +
                "resid=" + resid +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", address=" + address +
                ", vehicle=" + vehicle +
                '}';
    }
}
