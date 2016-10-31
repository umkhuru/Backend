package com.ramakhutla.ethan.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

/**
 * Created by Ethon on 2016/10/28.
 */
@Entity
public class Client implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    private String eMail;
    private String password;
    private int age;
    @Embedded
    private ContactDetails address;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="client_id")
    private List<Vehicle> vehicle;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="client_id")
    private List<Invoice> invoices;

    public Client() {
    }

    public Client(Builder builder) {
        this.password=builder.password;
        this.eMail=builder.eMail;
        this.id=builder.id;
        this.firstName=builder.firstName;
        this.lastName=builder.lastName;
        this.vehicle=builder.vehicle;
        this.address=builder.address;
        this.age=builder.age;
        this.invoices=builder.invoices;
    }

    public static class Builder{
        private Long id;
        private String eMail;
        private String password;
        private String firstName;
        private String lastName;
        private List<Vehicle> vehicle;
        private List<Invoice> invoices;
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

        public Builder eMail(String email)
        {
            this.eMail=email;
            return  this;
        }

        public Builder password(String password) throws Exception
        {
            this.password=convertPasswordToMD5(password);
            return this;
        }

        public Builder invoices(List<Invoice> list)
        {
            this.invoices=list;
            return this;
        }


        public Builder id(Long value)
        {
            this.id=value;
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

        public Builder copy(Client value)
        {
            this.eMail=value.geteMail();
            this.password=value.getPassword();
            this.id=value.getId();
            this.firstName=value.getFirstName();
            this.lastName=value.getLastName();
            this.vehicle=value.getVehicle();
            this.address=value.getAddress();
            this.age=value.getAge();
            this.invoices=value.getInvoices();

            return this;
        }

        public Client build(){
            return new Client(this);
        }

    }

    public List<Invoice> getInvoices() {
        return invoices;
    }

    private static String convertPasswordToMD5(String pass) throws NoSuchAlgorithmException {
        MessageDigest md= MessageDigest.getInstance("MD5");
        md.update(pass.getBytes());

        byte byteData[]=md.digest();

        StringBuffer sb=new StringBuffer();
        for(int x=0;x<byteData.length;x++)
        {
            sb.append(Integer.toString((byteData[x]&0xff)+0x100,16).substring(1));
        }
        return sb.toString();
    }

    public int getAge(){return age;}

    public Long getId() {
        return id;
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

    public String geteMail() {
        return eMail;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Client client = (Client) o;

        if (age != client.age) return false;
        if (id != null ? !id.equals(client.id) : client.id != null) return false;
        if (firstName != null ? !firstName.equals(client.firstName) : client.firstName != null) return false;
        if (lastName != null ? !lastName.equals(client.lastName) : client.lastName != null) return false;
        if (eMail != null ? !eMail.equals(client.eMail) : client.eMail != null) return false;
        if (password != null ? !password.equals(client.password) : client.password != null) return false;
        if (address != null ? !address.equals(client.address) : client.address != null) return false;
        if (vehicle != null ? !vehicle.equals(client.vehicle) : client.vehicle != null) return false;
        return invoices != null ? invoices.equals(client.invoices) : client.invoices == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (eMail != null ? eMail.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + age;
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (vehicle != null ? vehicle.hashCode() : 0);
        result = 31 * result + (invoices != null ? invoices.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", eMail='" + eMail + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                ", address=" + address +
                ", vehicle=" + vehicle +
                ", invoices=" + invoices +
                '}';
    }
}
