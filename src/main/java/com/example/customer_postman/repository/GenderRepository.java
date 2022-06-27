package com.example.customer_postman.repository;

import com.example.customer_postman.model.Customer;
import com.example.customer_postman.model.Gender;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GenderRepository extends JpaRepository <Gender,Long> {

}
