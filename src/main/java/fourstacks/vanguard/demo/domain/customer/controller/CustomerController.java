package fourstacks.vanguard.demo.domain.customer.controller;

import com.fasterxml.jackson.annotation.JsonIgnore;
import fourstacks.vanguard.demo.domain.customer.exceptions.CustomerNotFoundException;
import fourstacks.vanguard.demo.domain.customer.model.Customer;
import fourstacks.vanguard.demo.domain.customer.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Entity;


@RestController
@RequestMapping("/customer")
@Slf4j
public class CustomerController {

    private CustomerService customerService;

    @Autowired

    public CustomerController(CustomerService customerService) {
        this.customerService=customerService;
    }

    @PostMapping("")
    public ResponseEntity<Customer> create(@RequestBody Customer customer){
        customer = customerService.create(customer);
        return new ResponseEntity<>(customer, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> requestUser(@PathVariable Long id) throws CustomerNotFoundException {
        Customer response = customerService.getById(id);
        log.info(response.toString());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<Iterable<Customer>> getAll() throws CustomerNotFoundException {
        Iterable<Customer> all = customerService.findAll();
        return new ResponseEntity<>(all, HttpStatus.OK);
    }

}