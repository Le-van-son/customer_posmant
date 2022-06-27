package com.example.customer_postman.cotroller;

import com.example.customer_postman.model.Customer;
import com.example.customer_postman.repository.CustomerRepository;
import com.example.customer_postman.service.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
@RestController
@CrossOrigin("*")
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerServiceImpl customerService;
    @Autowired
    CustomerRepository customerRepository;
//    @ModelAttribute("customers")
//    public List<Customer>getAllCustomers() {
//        return customerService.findAll();
//    }
    @GetMapping(value = "")
    public ResponseEntity<List<Customer>> listAllCustomers() {
        List<Customer> customers = customerService.findAll();
        if (customers.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Customer> getCustomer(@PathVariable("id") long id) {
        System.out.println("Fetching Customer with id " + id);
        Customer customer = customerService.findById(id).get();
        if (customer == null) {
            System.out.println("Customer with id " + id + " not found");
            return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Customer>(customer, HttpStatus.OK);
    }

    @PostMapping(value = "/create")
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
        Customer customer1 = customerService.save(customer);
        return new ResponseEntity<>(customer1, HttpStatus.CREATED);
    }
    @GetMapping("/find/{id}")
    public ResponseEntity<Customer> findById(@PathVariable("id") long id){
        Customer customer = customerService.findById(id).get();
        return new ResponseEntity<>(customer, HttpStatus.CREATED);
    }

    @PutMapping( "/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable("id") long id, @RequestBody Customer customer) {
        Customer currentCustomer = customerService.findById(id).get();
        if (currentCustomer == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        customer.setId(currentCustomer.getId());
        Customer customer1 = customerService.save(customer);
        return new ResponseEntity<>(customer1, HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Customer> deleteCustomer(@PathVariable("id") long id) {
        Customer customer = customerService.findById(id).get();

        if (customer == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        customerService.remove(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping(value = "/searchlastname")
    public ResponseEntity<List<Customer>> searchByLastName(@RequestParam String lastname) {
        List<Customer> customers = customerService.findAllByLastNameContaining(lastname);
        if (customers == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    @GetMapping(value = "/searchfirstname")
    public ResponseEntity<List<Customer>> searchByFirstName(@RequestParam String lastname) {
        List<Customer> customers = customerService.findAllByFirstNameContaining(lastname);
        if (customers == null) {
            System.out.println(" not found");
            return new ResponseEntity<List<Customer>>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<Customer>>(customers, HttpStatus.OK);
    }


}
