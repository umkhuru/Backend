package com.ramakhutla.ethan.repositorytest;

import com.ramakhutla.ethan.App;
import com.ramakhutla.ethan.domain.ContactDetails;
import com.ramakhutla.ethan.domain.Manager;
import com.ramakhutla.ethan.domain.Staff;
import com.ramakhutla.ethan.domain.Station;
import com.ramakhutla.ethan.repository.ManagerRepository;
import com.ramakhutla.ethan.repository.StaffRepository;
import com.ramakhutla.ethan.repository.StationRepository;
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
public class StationCrudTest extends AbstractTestNGSpringContextTests {

    @Autowired
    StationRepository repository;
    @Autowired
    StaffRepository staffRepository;
    @Autowired
    ManagerRepository managerRepository;

    private Long id=(long)1;

    // @Test
    public void create() throws Exception
    {
        ContactDetails address=new ContactDetails
                .Builder("0218623790")
                .address("32 Kerk Straat, Paarl")
                //.email("carmaniax@gmail.com")
                .build();

        Station station=new Station
                .Builder("Car Maniax")
                .address(address)
                .build();
        repository.save(station);
        id=station.getId();
        Assert.assertNotNull(id);
    }

    // @Test
    public void read() throws Exception {
        Station station=repository.findOne(id);
        Assert.assertNotNull(station);
    }

    // @Test
    public void update() throws Exception {
        //Link all the entities that rely on this station...like staff
        //manager..
        Staff staff=staffRepository.findOne(1L);
        List<Staff> staffList=new ArrayList<>();
        staffList.add(staff);

        Manager manager=managerRepository.findOne(1L);
        List<Manager> managerList=new ArrayList<>();
        managerList.add(manager);

        Station oldStation=repository.findOne(1L);
        Station newStation=new Station
                .Builder(oldStation.getName())
                .copy(oldStation)
                .staff(staffList)
                .managerList(managerList)
                .build();

        repository.save(newStation);
        Assert.assertNotNull(newStation);
    }

    // @Test
    public void delete() throws Exception {
        Station station=repository.findOne(id);
        repository.delete(station);
        Station deletedStation=repository.findOne(id);
        Assert.assertNull(deletedStation);
    }
}
