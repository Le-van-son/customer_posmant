package com.example.customer_postman.service;

import com.example.customer_postman.model.Customer;
import com.example.customer_postman.model.Gender;
import com.example.customer_postman.repository.GenderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GenderService implements IGeneralService<Gender> {
    @Autowired
    GenderRepository genderRepository;
    @Override
    public List<Gender> findAll() {
        return genderRepository.findAll();
    }

    @Override
    public Page<Gender> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public Optional<Gender> findById(Long id) {
        return genderRepository.findById(id);
    }

    @Override
    public Customer save(Gender gender) {
        return null;
    }

    @Override
    public void remove(Long id) {

    }

    @Override
    public List<Customer> findAllByFirstNameContaining(String lastname) {
        return null;
    }

    @Override
    public List<Customer> findAllByLastNameContaining(String firstname) {
        return null;
    }

    @Override
    public List<Customer> getCustomerGender() {
        return null;
    }
}
