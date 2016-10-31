package com.ramakhutla.ethan.conf.factories;

import com.ramakhutla.ethan.domain.Manager;
import com.ramakhutla.ethan.domain.Staff;

import java.util.List;
import java.util.Map;

/**
 * Created by Ethon on 2016/10/28.
 */
public class ManagerFactory {

    public static Manager createManager(Map<String,String> values, int age, List<Staff> staffList)
    {
        Manager manager=new Manager.Builder(values.get("lastName"))
                .firstName(values.get("firstName"))
                .age(age)
                //.staff(staffList)
                .build();

        return manager;
    }
}
