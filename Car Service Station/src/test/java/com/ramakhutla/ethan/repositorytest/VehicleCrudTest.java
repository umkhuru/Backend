package com.ramakhutla.ethan.repositorytest;

import com.ramakhutla.ethan.App;
import com.ramakhutla.ethan.conf.factories.VehicleFactory;
import com.ramakhutla.ethan.domain.Vehicle;
import com.ramakhutla.ethan.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;

/**
 * Created by Ethon on 2016/10/28.
 */
@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class VehicleCrudTest extends AbstractTestNGSpringContextTests {

    @Autowired
    VehicleRepository repository;

    private Long id=2L;

    // // @Test
    public void create() throws Exception
    {
        Vehicle car= VehicleFactory.createVehicle("CJ 12334","2006 Ford Mustang");
        repository.save(car);
        id=car.getId();
        Assert.assertNotNull(id);
    }

    // // @Test
    public void read() throws Exception
    {
        Vehicle vehicle=repository.findOne(id);
        Assert.assertNotNull(vehicle);

    }

    // // @Test
    public void update() throws Exception
    {
        Vehicle vehicle=repository.findOne(id);

        Vehicle newVehicle=new Vehicle
                .Builder("BNJ 324 NC")
                .copy(vehicle)
                .model("2008 Nissan Almera")
                .build();

        repository.save(newVehicle);

        Vehicle updatedVehicle=repository.findOne(id);
        Assert.assertEquals("2008 Nissan Almera",updatedVehicle.getModel());

    }

    // // @Test
    public void delete() throws Exception
    {
        Vehicle vehicle=repository.findOne(id);
        repository.delete(vehicle);

        Vehicle deletedVehicle=repository.findOne(id);
        Assert.assertNull(deletedVehicle);
    }
}
