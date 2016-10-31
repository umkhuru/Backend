package com.ramakhutla.ethan.services.impl;

import com.ramakhutla.ethan.domain.Job;
import com.ramakhutla.ethan.domain.Staff;
import com.ramakhutla.ethan.repository.StaffRepository;
import com.ramakhutla.ethan.services.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ethon on 2016/10/28.
 */
@Service
public class StaffServiceImpl implements StaffService {

    @Autowired
    StaffRepository repository;

    @Override
    public Staff getStaff(long id) {
        return repository.findOne(id);
    }

    @Override
    public List<Staff> getStaffByMail(String mail) {
        List<Staff> allStaff=new ArrayList<>();

        Iterable<Staff> staff=repository.findByeMail(mail);
        for(Staff s:staff)
        {
            allStaff.add(s);
        }

        return allStaff;
    }

    @Override
    public List<Staff> getAllStaff() {
        List<Staff> allStaff=new ArrayList<>();
        Iterable<Staff> staffs=repository.findAll();

        for(Staff staff:staffs)
        {
            allStaff.add(staff);
        }

        return allStaff;
    }

    @Override
    public List<Job> getStaffJobs(long id) {
        return repository.findOne(id).getJobList();
    }

    @Override
    public Staff addStaff(Staff staff) {
        return repository.save(staff);
    }

    @Override
    public Staff updateStaff(Staff staff) {
        return repository.save(staff);
    }

    @Override
    public void removeStaff(Staff staff) {
        repository.delete(staff);
    }
}
