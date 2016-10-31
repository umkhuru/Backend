package com.ramakhutla.ethan.conf.factories;

import com.ramakhutla.ethan.domain.ContactDetails;
import com.ramakhutla.ethan.domain.Manager;
import com.ramakhutla.ethan.domain.Staff;
import com.ramakhutla.ethan.domain.Station;

import java.util.List;

/**
 * Created by Ethon on 2016/10/28.
 */
public class StationFactory {

    public static Station createStaion(ContactDetails address, List<Staff> staff
            , Manager manager, String name){
        Station station=new Station
                .Builder(name)
                .address(address)
                .staff(staff)
                .build();
        return station;
    }
}
