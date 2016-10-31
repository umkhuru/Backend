package com.ramakhutla.ethan.api;

import com.ramakhutla.ethan.domain.Client;
import com.ramakhutla.ethan.domain.Invoice;
import com.ramakhutla.ethan.domain.Vehicle;
import com.ramakhutla.ethan.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Ethon on 2016/10/31.
 */
@RestController
@RequestMapping(value="/clients/**")
public class ClientPage {

    @Autowired
    private ClientService service;

    @RequestMapping(value="/{id}",method= RequestMethod.GET,produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Client> getClient(@PathVariable("id") Long id)
    {
        Client client=service.getClient(id);
        if(client==null) {
            System.out.println("Client with id:" + id + " not found!");
            return new ResponseEntity<Client>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Client>(client,HttpStatus.OK);
    }


    @RequestMapping(value="/create",method= RequestMethod.POST,produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Client> addClient(@RequestBody Client client)//,UriComponentsBuilder ucBuilder)
    {
        System.out.println("Creating client " + client.getLastName());
        service.addClient(client);

        return new ResponseEntity<Client>(client,HttpStatus.CREATED);
    }


    @RequestMapping(value="/{id}/update",method= RequestMethod.PUT)
    public ResponseEntity<Client> updateClient(@PathVariable("id") long id,@RequestBody Client client)
    {
        System.out.println("Updating Client "+id);
        Client currentClient=service.getClient(id);

        if(currentClient==null)
        {
            System.out.println("Client with id="+id+" not found");
            return new ResponseEntity<Client>(HttpStatus.NOT_FOUND);
        }

        Client newClient=new Client
                .Builder(client.getLastName())
                .copy(client)
                .id(id)
                .build();
        service.updateClient(newClient);
        return new ResponseEntity<Client>(newClient,HttpStatus.OK);
    }

    @RequestMapping(value="/{id}/delete",method= RequestMethod.DELETE)
    public ResponseEntity<Client> deleteClient(@PathVariable("id") long id)
    {
        System.out.println("Fetching & Deleteing Client with id="+id);

        Client client=service.getClient(id);
        if(client==null) {
            System.out.println("Unable to delete. Client with " + id + " not found");
            return new ResponseEntity<Client>(HttpStatus.NOT_FOUND);
        }

        service.removeClient(client);
        return new ResponseEntity<Client>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value="/{id}/vehicles",method= RequestMethod.GET)
    public ResponseEntity<List<Vehicle>> getClientVehicles(@PathVariable("id") long id)
    {
        List<Vehicle> vehicles=service.getVehicles(id);
        if(vehicles.isEmpty())
        {
            return new ResponseEntity<List<Vehicle>>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<List<Vehicle>>(vehicles,HttpStatus.OK);
    }


    @RequestMapping(value="/clients",method= RequestMethod.GET)
    public ResponseEntity<List<Client>> listClients()
    {
        List<Client> clients=service.getClients();
        if(clients.isEmpty())
        {
            return new ResponseEntity<List<Client>>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<List<Client>>(clients,HttpStatus.OK);
    }

    @RequestMapping(value="/{id}/invoices/",method= RequestMethod.GET)
    private ResponseEntity<List<Invoice>> getClientInvoice(@PathVariable("id") long id)
    {
        List<Invoice> invoices=service.getInvoices(id);
        if(invoices.isEmpty())
        {
            return new ResponseEntity<List<Invoice>>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<List<Invoice>>(invoices, HttpStatus.OK);
    }
}
