package com.ramakhutla.ethan.services;

import com.ramakhutla.ethan.domain.Job;
import com.ramakhutla.ethan.domain.Staff;

import java.util.List;

/**
 * Created by Ethon on 2016/10/28.
 */
public interface StaffService {

    List<Staff> getAllStaff();
    List<Job> getStaffJobs(long id);
    List<Staff> getStaffByMail(String mail);
    Staff addStaff(Staff staff);
    Staff updateStaff(Staff staff);
    Staff getStaff(long id);
    void removeStaff(Staff staff);
}
