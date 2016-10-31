package com.ramakhutla.ethan.services;

import com.ramakhutla.ethan.domain.Manager;
import com.ramakhutla.ethan.domain.Staff;
import com.ramakhutla.ethan.domain.Station;

import java.util.List;

/**
 * Created by Ethon on 2016/10/28.
 */
public interface StationService {

    List<Station> getStations();
    List<Staff> getStaff(long id);
    List<Manager> getStationManager(long id);

    Station getStation(long id);
    Station addStation(Station station);
    Station updateStation(Station station);
    void removeStation(Station station);
}
