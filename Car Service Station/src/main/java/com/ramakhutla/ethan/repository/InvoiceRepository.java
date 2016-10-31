package com.ramakhutla.ethan.repository;

import com.ramakhutla.ethan.domain.Invoice;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Ethon on 2016/10/28.
 */
@Repository
public interface InvoiceRepository extends CrudRepository<Invoice,Long>{
}
