package fourstacks.vanguard.demo.domain.customer.controller;
import fourstacks.vanguard.demo.domain.customer.exceptions.CustomerNotFoundException;
import fourstacks.vanguard.demo.domain.customer.model.Customer;
import fourstacks.vanguard.demo.domain.customer.service.CustomerService;
import fourstacks.vanguard.demo.domain.goal.exceptions.GoalNotFoundException;
import fourstacks.vanguard.demo.domain.goal.model.Goal;
import fourstacks.vanguard.demo.domain.goal.service.GoalService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
@Slf4j
public class CustomerController {

    private CustomerService customerService;
    private GoalService goalService;


    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService=customerService;
    }

    @PostMapping("")
    public ResponseEntity<Customer> create(@RequestBody Customer customer){
        customer = customerService.create(customer);
        return new ResponseEntity<>(customer, HttpStatus.CREATED);
    }

    @PutMapping("")
    public ResponseEntity<Customer> updateGoal(@RequestBody Customer customer, Goal goal) throws CustomerNotFoundException, GoalNotFoundException {
        goal = (Goal) goalService.findAll();
        Customer response = customerService.createGoal(customer, goal);
        return new ResponseEntity<>(response, HttpStatus.OK);
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