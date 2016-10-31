package com.ramakhutla.ethan.repository;

import com.ramakhutla.ethan.domain.Job;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Ethon on 2016/10/28.
 */
@Repository
public interface JobRepository extends CrudRepository<Job,Long>{
}
