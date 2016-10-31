package com.ramakhutla.ethan.services.impl;

import com.ramakhutla.ethan.domain.Vehicle;
import com.ramakhutla.ethan.repository.VehicleRepository;
import com.ramakhutla.ethan.services.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ethon on 2016/10/28.
 */
@Service
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    VehicleRepository repository;
    @Override
    public List<Vehicle> getVehicles() {
        List<Vehicle> allCars=new ArrayList<Vehicle>();

        Iterable<Vehicle> cars=repository.findAll();
        for(Vehicle car: cars)
        {
            allCars.add(car);
        }

        return allCars;
    }

    @Override
    public Vehicle getVehicle(long id) {
        return repository.findOne(id);
    }

    @Override
    public Vehicle addVehicle(Vehicle vehicle) {
        return repository.save(vehicle);
    }

    @Override
    public Vehicle updateVehicle(Vehicle vehicle) {
        return repository.save(vehicle);
    }

    @Override
    public void removeVehicle(Vehicle vehicle) {
        repository.delete(vehicle);
    }
}
