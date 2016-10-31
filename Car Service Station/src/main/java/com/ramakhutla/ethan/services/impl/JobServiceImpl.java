package com.ramakhutla.ethan.services.impl;

import com.ramakhutla.ethan.domain.Invoice;
import com.ramakhutla.ethan.domain.Job;
import com.ramakhutla.ethan.repository.JobRepository;
import com.ramakhutla.ethan.services.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ethon on 2016/10/28.
 */
@Service
public class JobServiceImpl implements JobService {

    @Autowired
    JobRepository repository;

    @Override
    public Job getJob(long id) {
        return repository.findOne(id);
    }

    @Override
    public List<Job> getJobs() {
        List<Job> allJobs=new ArrayList<>();
        Iterable<Job> jobs=repository.findAll();

        for(Job job:jobs)
        {
            allJobs.add(job);
        }

        return allJobs;
    }

    @Override
    public Job addJob(Job job) {
        return repository.save(job);
    }

    @Override
    public Job updateJob(Job job) {
        return repository.save(job);
    }

    @Override
    public List<Invoice> getInvoices(long id) {
        return repository.findOne(id).getInvoiceList();
    }

    @Override
    public void removeJob(Job job) {
        repository.delete(job);
    }
}
