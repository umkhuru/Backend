package com.ramakhutla.ethan.services;

import com.ramakhutla.ethan.domain.Vehicle;

import java.util.List;

/**
 * Created by Ethon on 2016/10/28.
 */
public interface VehicleService {

    List<Vehicle> getVehicles();

    Vehicle getVehicle(long id);
    Vehicle addVehicle(Vehicle vehicle);
    Vehicle updateVehicle(Vehicle vehicle);
    void removeVehicle(Vehicle vehicle);
}
