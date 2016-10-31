package com.ramakhutla.ethan.servicetest;

import com.ramakhutla.ethan.App;
import com.ramakhutla.ethan.domain.ContactDetails;
import com.ramakhutla.ethan.domain.Manager;
import com.ramakhutla.ethan.services.ManagerService;
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
public class ManagerServiceTest extends AbstractTestNGSpringContextTests {

    @Autowired
    ManagerService service;

    private Long id=1L;

    //    @Test
    public void create() throws Exception {
        ContactDetails address=new ContactDetails
                .Builder("0611092344")
                .address("2 Kerk Straat,Hopetown")
                //.email("msmith@gmail.com")
                .build();

        Manager manager=new Manager
                .Builder("Smith")
                .age(29)
                .firstName("Markus")
                .address(address)
                .build();

        service.addManager(manager);
        id=manager.getID();
        Assert.assertNotNull(id);

    }

    //    @Test
    public void read() throws Exception {
        Manager manager=service.getManager(id);
        Assert.assertNotNull(manager);

    }

    //    @Test
    public void update() throws Exception {
        //Managers and staff cannot service their personal vehicle(s) at this point..
        //Due to business rule(s)
        Manager manager=service.getManager(id);
        Manager newManager=new Manager
                .Builder(manager.getlastName())
                .copy(manager)
                .firstName("Thinie")
                .build();
        service.updateManager(newManager);
        Assert.assertEquals(newManager.getfirstName(),"Thinie");
    }

    //    @Test
    public void delete() throws Exception {
        Manager manager=service.getManager(id);
        service.removeManager(manager);
        Manager deletedManager=service.getManager(id);
        Assert.assertNull(deletedManager);

    }
}
