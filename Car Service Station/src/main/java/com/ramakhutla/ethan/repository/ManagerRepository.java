package com.ramakhutla.ethan.repository;

import com.ramakhutla.ethan.domain.Manager;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Ethon on 2016/10/28.
 */
@Repository
public interface ManagerRepository extends CrudRepository<Manager,Long>{
}
