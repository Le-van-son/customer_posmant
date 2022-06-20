package com.example.customer_postman.repository;

import com.example.customer_postman.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {
    List<Customer>findAllByFirstNameContaining(String lastname);
    List<Customer>findAllByLastNameContaining(String firstname);
    @Query(value = "select * from customer order by id desc LIMIT 3",nativeQuery = true)
    List<Customer> getTop3();

}
