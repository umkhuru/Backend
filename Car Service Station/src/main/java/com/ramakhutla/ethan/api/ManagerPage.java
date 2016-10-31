package com.ramakhutla.ethan.api;

import com.ramakhutla.ethan.domain.Manager;
import com.ramakhutla.ethan.services.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Ethon on 2016/10/31.
 */
@RestController
@RequestMapping(value="/managers/**")
public class ManagerPage {

    @Autowired
    ManagerService service;

    @RequestMapping(value="/managers",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Manager>> getAllManagers()
    {
        List<Manager> managers=service.getAllManagers();
        if(managers.isEmpty())
        {
            return new ResponseEntity<List<Manager>>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<List<Manager>>(managers,HttpStatus.OK);
    }

    @RequestMapping(value="/create",method = RequestMethod.POST)
    public ResponseEntity<Manager> addManager(@RequestBody Manager manager)
    {
        service.addManager(manager);
        return new ResponseEntity<Manager>(manager,HttpStatus.OK);
    }

    @RequestMapping(value="/{id}",method = RequestMethod.GET)
    public ResponseEntity<Manager> getManager(@PathVariable("id") long id)
    {
        Manager manager=service.getManager(id);
        if(manager==null)
        {
            return new ResponseEntity<Manager>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Manager>(manager,HttpStatus.OK);
    }

    @RequestMapping(value="/{id}/update",method = RequestMethod.PUT)
    public ResponseEntity<Manager> updateManager(@PathVariable("id") long id,@RequestBody Manager manager)
    {
        Manager oldManager=service.getManager(id);
        if(oldManager==null)
        {
            return new ResponseEntity<Manager>(HttpStatus.NOT_FOUND);
        }
        Manager updatedManager=new Manager
                .Builder(manager.getlastName())
                .copy(manager)
                .id(oldManager.getID())
                .build();

        service.updateManager(updatedManager);
        return new ResponseEntity<Manager>(updatedManager,HttpStatus.OK);
    }

    @RequestMapping(value="/{id}/delete",method = RequestMethod.DELETE)
    public ResponseEntity<Manager> removeManager(@PathVariable("id") long id)
    {
        Manager manager=service.getManager(id);
        if(manager==null)
        {
            return new ResponseEntity<Manager>(HttpStatus.NOT_FOUND);
        }

        service.removeManager(manager);
        return new ResponseEntity<Manager>(manager,HttpStatus.NO_CONTENT);
    }
}
