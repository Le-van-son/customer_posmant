package com.example.customer_postman.service;

import com.example.customer_postman.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IGeneralService<T> {
    List<T> findAll();
    Page<T> findAll(Pageable pageable);
    Optional<T> findById(Long id);

    Customer save(T t);

    void remove(Long id);

    List<Customer>findAllByFirstNameContaining(String lastname);
    List<Customer>findAllByLastNameContaining(String firstname);
    List<Customer> getCustomerGender();
}
