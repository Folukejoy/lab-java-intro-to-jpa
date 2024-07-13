package com.ironhack.week6;

import com.ironhack.week6.model.Customer;
import com.ironhack.week6.model.CustomerStatus;
import com.ironhack.week6.repository.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
public class CustomerRepositoryTest {

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    public void testCreateNewCustomer() {
        Customer customer = new Customer("John Doe", CustomerStatus.GOLD, 10000);
        customerRepository.save(customer);
        assertTrue(customerRepository.findById(customer.getCustomerId()).isPresent());
    }

    @Test
    public void testFindCustomerByName() {
        Customer customer = new Customer("Jane Smith", CustomerStatus.SILVER, 5000);
        customerRepository.save(customer);

        List<Customer> customers = customerRepository.findByCustomerName("Jane Smith");
        assertEquals(1, customers.size());
        assertEquals("Jane Smith", customers.get(0).getCustomerName());
    }

    @Test
    public void testFindCustomerByStatus() {
        Customer customer = new Customer("Alice Johnson", CustomerStatus.NONE, 3000);
        customerRepository.save(customer);

        List<Customer> customers = customerRepository.findByCustomerStatus(CustomerStatus.NONE);
        assertEquals(1, customers.size());
        assertEquals(CustomerStatus.NONE, customers.get(0).getCustomerStatus());
    }
}
