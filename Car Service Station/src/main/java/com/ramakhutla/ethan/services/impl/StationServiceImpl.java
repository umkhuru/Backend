package com.ramakhutla.ethan.services.impl;

import com.ramakhutla.ethan.domain.Manager;
import com.ramakhutla.ethan.domain.Staff;
import com.ramakhutla.ethan.domain.Station;
import com.ramakhutla.ethan.repository.StationRepository;
import com.ramakhutla.ethan.services.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ethon on 2016/10/28.
 */
@Service
public class StationServiceImpl implements StationService {

    @Autowired
    StationRepository repository;

    @Override
    public Station getStation(long id) {
        return repository.findOne(id);
    }

    @Override
    public List<Station> getStations() {
        List<Station> allStations=new ArrayList<>();
        Iterable<Station> stations=repository.findAll();
        for(Station station:stations)
        {
            allStations.add(station);
        }

        return allStations;
    }

    @Override
    public List<Staff> getStaff(long id) {
        return repository.findOne(id).getStaff();
    }

    @Override
    public List<Manager> getStationManager(long id) {
        return repository.findOne(id).getManagerList();
    }

    @Override
    public Station addStation(Station station) {
        return repository.save(station);
    }

    @Override
    public Station updateStation(Station station) {
        return repository.save(station);
    }

    @Override
    public void removeStation(Station station) {
        repository.delete(station);
    }
}
