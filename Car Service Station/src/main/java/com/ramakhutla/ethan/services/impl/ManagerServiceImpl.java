package com.ramakhutla.ethan.services.impl;

import com.ramakhutla.ethan.domain.Manager;
import com.ramakhutla.ethan.repository.ManagerRepository;
import com.ramakhutla.ethan.services.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ethon on 2016/10/28.
 */
@Service
public class ManagerServiceImpl implements ManagerService {

    @Autowired
    ManagerRepository repository;

    @Override
    public Manager getManager(long id) {
        return repository.findOne(id);
    }

    @Override
    public List<Manager> getAllManagers() {
        List<Manager> allManagers=new ArrayList<>();
        Iterable<Manager> managers=repository.findAll();

        for(Manager manager:managers)
        {
            allManagers.add(manager);
        }

        return allManagers;
    }

    @Override
    public Manager addManager(Manager manager) {
        return repository.save(manager);
    }

    @Override
    public Manager updateManager(Manager manager) {
        return repository.save(manager);
    }

    @Override
    public void removeManager(Manager manager) {
        repository.delete(manager);
    }
}
