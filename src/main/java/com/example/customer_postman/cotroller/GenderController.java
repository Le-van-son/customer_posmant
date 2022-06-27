package com.example.customer_postman.cotroller;

import com.example.customer_postman.model.Customer;
import com.example.customer_postman.model.Gender;
import com.example.customer_postman.service.GenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@CrossOrigin("*")
@RequestMapping("/genders")
public class GenderController {
    @Autowired
    GenderService genderService;
    @GetMapping(value = "")
    public ResponseEntity<List<Gender>>listAllGender() {
        List<Gender> genders = genderService.findAll();
        if (genders.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<>(genders, HttpStatus.OK);
    }
}
