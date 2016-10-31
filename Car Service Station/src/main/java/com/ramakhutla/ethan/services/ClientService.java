package com.ramakhutla.ethan.services;

import com.ramakhutla.ethan.domain.Client;
import com.ramakhutla.ethan.domain.Invoice;
import com.ramakhutla.ethan.domain.Vehicle;

import java.util.List;

/**
 * Created by Ethon on 2016/10/28.
 */
public interface ClientService {

    List<Client> getClients();
    List<Vehicle> getVehicles(long id);
    List<Invoice> getInvoices(long id);
    //Crud services..
    Client getClient(long id);
    Client addClient(Client client);
    void removeClient(Client client);
    Client updateClient(Client client);
}
