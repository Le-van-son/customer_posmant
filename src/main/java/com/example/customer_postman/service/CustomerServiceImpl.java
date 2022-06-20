package com.example.customer_postman.service;

import com.example.customer_postman.model.Customer;
import com.example.customer_postman.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements IGeneralService<Customer>{
    @Autowired
    CustomerRepository customerRepository;


    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Page<Customer> findAll(Pageable pageable) {
        return customerRepository.findAll(pageable);
    }

    @Override
    public Optional<Customer> findById(Long id) {
        return customerRepository.findById(id);
    }

    @Override
    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public void remove(Long id) {
    customerRepository.deleteById(id);
    }

    @Override
    public List<Customer> findAllByFirstNameContaining(String lastname) {
        return customerRepository.findAllByFirstNameContaining(lastname);
    }

    @Override
    public List<Customer> findAllByLastNameContaining(String firstname) {
        return customerRepository.findAllByLastNameContaining(firstname);
    }

}
