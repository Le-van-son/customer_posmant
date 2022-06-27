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
    @Query(value = "select customer.id,customer.first_name,g.gender_name  from customer join gender g on customer.gender_id = g.id",nativeQuery = true)
    List<Customer> getCustomerGender();
}
