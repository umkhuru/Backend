package com.ramakhutla.ethan.conf.factories;

import com.ramakhutla.ethan.domain.Staff;

/**
 * Created by Ethon on 2016/10/28.
 */
public class StaffFactory {

    public static Staff createStaff(String lName,String fname,int age)
    {
        Staff staff=new Staff.Builder(lName)
                .firstName(fname)
                .age(age)
                .build();
        return staff;
    }
}
