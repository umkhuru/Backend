package com.ramakhutla.ethan.repository;

import com.ramakhutla.ethan.domain.Vehicle;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Ethon on 2016/10/28.
 */
@Repository
public interface VehicleRepository extends CrudRepository<Vehicle,Long>{
}
