package com.jobs.repository;

import com.jobs.entity.Customer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 *
 * Created by Wan on 2017/8/20.
 */
public interface CustomerRepository extends CrudRepository<Customer, Long> {

    List<Customer> findByLastName(String lastName);
}