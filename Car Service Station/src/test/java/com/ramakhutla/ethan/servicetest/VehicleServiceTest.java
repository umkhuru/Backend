package com.ramakhutla.ethan.servicetest;

import com.ramakhutla.ethan.App;
import com.ramakhutla.ethan.conf.factories.VehicleFactory;
import com.ramakhutla.ethan.domain.Client;
import com.ramakhutla.ethan.domain.Vehicle;
import com.ramakhutla.ethan.repository.VehicleRepository;
import com.ramakhutla.ethan.services.ClientService;
import com.ramakhutla.ethan.services.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ethon on 2016/10/28.
 */
@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class VehicleServiceTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private VehicleService service;
    @Autowired
    private ClientService clientService;

    private Long id=1L;

    @Autowired
    VehicleRepository repository;

    //    @Test
    public void create() throws Exception {
        Vehicle car= VehicleFactory.createVehicle("CJ 12334", "2006 Ford Mustang");
        service.addVehicle(car);
        id=car.getId();
        Assert.assertNotNull(id);
    }

    //    @Test
    public void read() throws Exception {
        Vehicle vehicle=service.getVehicle(id);
        Assert.assertNotNull(vehicle);

    }

    //    @Test
    public void update() throws Exception {
        Vehicle vehicle=service.getVehicle(id);

        Vehicle updatedVehicle=new Vehicle
                .Builder(vehicle.getReg())
                .copy(vehicle)
                .build();

        List<Vehicle> cars=new ArrayList<>();
        cars.add(updatedVehicle);
        //Creating a client and adding the created vehicle onto an arraylist..
        //Giving the vehicle an owner..

        Client client=clientService.getClient(id);
        Client updatedClient=new Client
                .Builder(client.getLastName())
                .copy(client)
                .vehicle(cars)
                .build();

        clientService.updateClient(updatedClient);
        Assert.assertEquals(updatedClient.getVehicle(),cars);
    }


    //    @Test
    public void delete() throws Exception {
        Vehicle vehicle=service.getVehicle(id);
        service.removeVehicle(vehicle);
        Vehicle deletedVehicle=service.getVehicle(id);
        Assert.assertNull(deletedVehicle);
    }
}
