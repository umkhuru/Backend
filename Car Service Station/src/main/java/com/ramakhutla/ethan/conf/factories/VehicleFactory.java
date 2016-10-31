package com.ramakhutla.ethan.conf.factories;

import com.ramakhutla.ethan.domain.Vehicle;

/**
 * Created by Ethon on 2016/10/28.
 */
public class VehicleFactory {

    public static Vehicle createVehicle(String reg,String model)
    {
        Vehicle vehicle=new Vehicle.Builder(reg)
                .model(model)
                .build();
        return vehicle;
    }
}
