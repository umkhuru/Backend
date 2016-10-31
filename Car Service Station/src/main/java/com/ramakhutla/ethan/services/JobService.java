package com.ramakhutla.ethan.services;

import com.ramakhutla.ethan.domain.Invoice;
import com.ramakhutla.ethan.domain.Job;

import java.util.List;

/**
 * Created by Ethon on 2016/10/28.
 */
public interface JobService {

    List<Job> getJobs();
    Job addJob(Job job);
    Job updateJob(Job job);
    List<Invoice> getInvoices(long id);
    void removeJob(Job job);
    Job getJob(long id);
}
