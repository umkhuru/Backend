package com.ramakhutla.ethan.services;

import com.ramakhutla.ethan.domain.Manager;

import java.util.List;

/**
 * Created by Ethon on 2016/10/28.
 */
public interface ManagerService {

    List<Manager> getAllManagers();
    Manager addManager(Manager manager);
    Manager updateManager(Manager manager);
    void removeManager(Manager manager);
    Manager getManager(long id);
}
