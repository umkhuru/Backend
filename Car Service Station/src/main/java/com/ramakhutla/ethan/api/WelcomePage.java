package com.ramakhutla.ethan.api;

import com.ramakhutla.ethan.domain.ContactDetails;
import com.ramakhutla.ethan.domain.Station;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Ethon on 2016/10/31.
 */
@RestController
@RequestMapping("/")
public class WelcomePage {

    @RequestMapping(method = RequestMethod.GET)
    public Station getStation() {
        ContactDetails address = new ContactDetails
                .Builder("0611092633")

                .address("5 BarkleyRoad, Kimberley")
                .build();

        Station station = new Station
                .Builder("Legends Service")
                .address(address)
                .build();
        return station;

    }
}
