package com.ramakhutla.ethan.conf.factories;

import com.ramakhutla.ethan.domain.Client;
import com.ramakhutla.ethan.domain.ContactDetails;
import com.ramakhutla.ethan.domain.Vehicle;

import java.util.List;
import java.util.Map;

/**
 * Created by Ethon on 2016/10/28.
 */
public class ClientFactory {

    public static Client createClient(Map<String,String> values, int age
            , ContactDetails address, List<Vehicle> cars)
    {
        Client client=new Client
                .Builder(values.get("lastName"))
                .firstName(values.get("firstName"))
                .address(address)
                .vehicle(cars)
                .age(age)
                .build();
        return client;
    }
}
