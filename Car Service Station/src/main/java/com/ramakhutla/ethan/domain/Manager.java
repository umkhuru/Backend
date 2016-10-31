package com.ramakhutla.ethan.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Ethon on 2016/10/28.
 */
@Entity
public class Manager implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    private int age;
    @Embedded
    private ContactDetails address;

    public Manager() {
    }

    public Manager(Builder builder) {
        this.id=builder.id;
        this.firstName=builder.firstName;
        this.lastName=builder.lastName;
        this.age=builder.age;
        this.address=builder.address;
    }

    public static class Builder{
        private Long id;
        private String firstName;
        private String lastName;
        private int age;
        private ContactDetails address;

        public Builder(String lastName)
        {
            this.lastName=lastName;
        }

        public Builder address(ContactDetails address)
        {
            this.address=address;
            return this;
        }

        public  Builder firstName(String value)
        {
            this.firstName=value;
            return this;
        }

        public  Builder age(int value)
        {
            this.age=value;
            return this;
        }

        public Builder id(long id)
        {
            this.id=id;
            return this;
        }

        public Builder copy(Manager value)
        {
            this.id=value.getID();
            this.firstName=value.getfirstName();
            this.lastName=value.getlastName();
            this.age=value.getAge();
            this.address=value.getAddress();
            return this;
        }

        public Manager build()
        {
            return new Manager(this);
        }


    }

    public ContactDetails getAddress() {
        return address;
    }

    public Long getID() {
        return id;
    }

    public String getfirstName() {
        return firstName;
    }

    public String getlastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Manager manager = (Manager) o;

        if (age != manager.age) return false;
        if (id != null ? !id.equals(manager.id) : manager.id != null) return false;
        if (firstName != null ? !firstName.equals(manager.firstName) : manager.firstName != null) return false;
        if (lastName != null ? !lastName.equals(manager.lastName) : manager.lastName != null) return false;
        return address != null ? address.equals(manager.address) : manager.address == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + age;
        result = 31 * result + (address != null ? address.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", address=" + address +
                '}';
    }
}
