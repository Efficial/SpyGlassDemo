package fourstacks.vanguard.demo.domain.customer.service;

import fourstacks.vanguard.demo.domain.customer.exceptions.CustomerNotFoundException;
import fourstacks.vanguard.demo.domain.customer.model.Customer;

public interface CustomerService {
    Customer create(Customer customer);
    Customer getById(Long id) throws CustomerNotFoundException;
    //Customer getByFullName(String firstName, String lastName) throws CustomerNotFoundException;
    Customer update(Customer customer) throws CustomerNotFoundException;
    void delete(Long id) throws CustomerNotFoundException;
    Iterable<Customer> findAll();
    Customer findByUserName(String userName) throws CustomerNotFoundException;
}
