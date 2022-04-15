package fourstacks.vanguard.demo.domain.customer.controller;

import com.fasterxml.jackson.annotation.JsonIgnore;
import fourstacks.vanguard.demo.domain.customer.model.Customer;
import fourstacks.vanguard.demo.domain.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Entity;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    private CustomerService customerService;

    @Autowired

    public CustomerController(CustomerService customerService) {
        this.customerService=customerService;
    }

    @PostMapping("")
    public ResponseEntity<Customer> create(@RequestBody Customer actor){
        actor = customerService.create(actor);
        return new ResponseEntity<>(actor, HttpStatus.CREATED);
    }

}
