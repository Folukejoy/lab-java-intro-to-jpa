package com.ironhack.week6.repository;

import com.ironhack.week6.model.Customer;
import com.ironhack.week6.model.CustomerStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;


public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    List<Customer> findByCustomerName(String customerName);
    List<Customer> findByCustomerStatus(CustomerStatus customerStatus);

}



