package com.ramakhutla.ethan.api;

import com.ramakhutla.ethan.domain.Job;
import com.ramakhutla.ethan.domain.Staff;
import com.ramakhutla.ethan.services.StaffService;
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
@RequestMapping(value="/staff/**")
public class StaffPage {

    @Autowired
    StaffService service;

    @RequestMapping(value="/{id}",method= RequestMethod.GET,produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Staff> getClient(@PathVariable("id") long id)
    {
        Staff staff=service.getStaff(id);
        if(staff==null)
        {
            return new ResponseEntity<Staff>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Staff>(staff,HttpStatus.OK);

    }

    @RequestMapping(value="/create",method=RequestMethod.POST,produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Staff> addStaff(@RequestBody Staff staff)
    {
        service.addStaff(staff);
        return new ResponseEntity<Staff>(staff,HttpStatus.CREATED);
    }

    @RequestMapping(value="/{id}/update",method=RequestMethod.PUT)
    public ResponseEntity<Staff> updateStaff(@PathVariable("id") long id,@RequestBody Staff staff)
    {
        Staff oldStaff=service.getStaff(id);
        if(oldStaff==null)
        {
            return new ResponseEntity<Staff>(HttpStatus.NOT_FOUND);
        }

        Staff updatedStaff=new Staff
                .Builder(staff.getLastName())
                .copy(staff)
                .id(oldStaff.getId())
                .build();

        service.updateStaff(updatedStaff);
        return new ResponseEntity<Staff>(updatedStaff,HttpStatus.OK);
    }

    @RequestMapping(value="/{id}/delete",method=RequestMethod.DELETE)
    public ResponseEntity<Staff> deleteStaff(@PathVariable("id") long id)
    {
        Staff staff=service.getStaff(id);
        if(staff==null)
        {
            return new ResponseEntity<Staff>(HttpStatus.NOT_FOUND);
        }

        service.removeStaff(staff);
        return new ResponseEntity<Staff>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value="/{id}/jobs",method=RequestMethod.GET)
    public ResponseEntity<List<Job>> getStaffJobs(@PathVariable("id") long id)
    {
        List<Job> jobs=service.getStaffJobs(id);
        if(jobs.isEmpty())
        {
            return new ResponseEntity<List<Job>>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<List<Job>>(jobs,HttpStatus.OK);
    }

    @RequestMapping(value="/staff",method=RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Staff>> getAllStaff()
    {
        List<Staff> staff=service.getAllStaff();
        if(staff.isEmpty())
        {
            return new ResponseEntity<List<Staff>>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<List<Staff>>(staff,HttpStatus.OK);
    }

    @RequestMapping(value="/staff/search/{email:.+}",method=RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Staff>> getStaffByMail(@PathVariable("email") String mail)
    {
        List<Staff> staffList=service.getStaffByMail(mail);
        if(staffList.isEmpty())
        {
            return new ResponseEntity<List<Staff>>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<List<Staff>>(staffList,HttpStatus.OK);
    }
}
