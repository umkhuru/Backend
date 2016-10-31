package com.ramakhutla.ethan.repository;

import com.ramakhutla.ethan.domain.Staff;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Ethon on 2016/10/28.
 */
@Repository
public interface StaffRepository extends CrudRepository<Staff,Long>{
    List<Staff> findByeMail(String mail);
}
