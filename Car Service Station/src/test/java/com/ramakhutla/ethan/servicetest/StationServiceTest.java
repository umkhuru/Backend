package com.ramakhutla.ethan.servicetest;

import com.ramakhutla.ethan.App;
import com.ramakhutla.ethan.domain.ContactDetails;
import com.ramakhutla.ethan.domain.Manager;
import com.ramakhutla.ethan.domain.Staff;
import com.ramakhutla.ethan.domain.Station;
import com.ramakhutla.ethan.services.ManagerService;
import com.ramakhutla.ethan.services.StaffService;
import com.ramakhutla.ethan.services.StationService;
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
public class StationServiceTest extends AbstractTestNGSpringContextTests {

    @Autowired
    StationService service;
    @Autowired
    StaffService staffservice;
    @Autowired
    ManagerService managerService;

    private Long id=1L;

    //    @Test
    public void create() throws Exception {
        ContactDetails address=new ContactDetails
                .Builder("0218623790")
                .address("32 Kerk Straat, Paarl")
                //.email("carmaniax@gmail.com")
                .build();

        Station station=new Station
                .Builder("Car Maniax")
                .address(address)
                .build();
        service.addStation(station);
        id=station.getId();
        Assert.assertNotNull(id);

    }

    //    @Test
    public void read() throws Exception {
        Station station=service.getStation(id);
        Assert.assertNotNull(station);

    }

    //    @Test
    public void update() throws Exception {

        Staff staff=staffservice.getStaff(id);
        List<Staff> staffList=new ArrayList<>();
        staffList.add(staff);

        Manager manager=managerService.getManager(id);
        List<Manager> managerList=new ArrayList<>();
        managerList.add(manager);

        Station oldStation=service.getStation(id);
        Station updatedStation=new Station
                .Builder(oldStation.getName())
                .copy(oldStation)
                .managerList(managerList)
                .staff(staffList)
                .build();

        service.updateStation(updatedStation);
        Assert.assertEquals(updatedStation.getManagerList(),managerList);
        Assert.assertEquals(updatedStation.getStaff(),staffList);
    }


    //    @Test
    public void delete() throws Exception {

    }
}
