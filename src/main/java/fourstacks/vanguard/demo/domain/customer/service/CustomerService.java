package fourstacks.vanguard.demo.domain.customer.service;

import fourstacks.vanguard.demo.domain.customer.exceptions.CustomerNotFoundException;
import fourstacks.vanguard.demo.domain.customer.model.Customer;
import fourstacks.vanguard.demo.domain.goal.model.Goal;

public interface CustomerService {
    Customer create(Customer customer);
    Customer createGoal(Customer customer, Goal goal) throws CustomerNotFoundException;
    Customer getById(Long id) throws CustomerNotFoundException;
    //Customer getByFullName(String firstName, String lastName) throws CustomerNotFoundException;
    Customer update(Customer customer) throws CustomerNotFoundException;
    void delete(Long id) throws CustomerNotFoundException;
    Iterable<Customer> findAll();
    Iterable<Goal> findAllGoalsByCustomer(Customer customer) throws CustomerNotFoundException;
    Customer findByUserName(String userName) throws CustomerNotFoundException;
}
