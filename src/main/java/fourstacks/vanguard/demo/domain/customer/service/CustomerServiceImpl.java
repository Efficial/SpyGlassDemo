package fourstacks.vanguard.demo.domain.customer.service;

import fourstacks.vanguard.demo.domain.customer.exceptions.CustomerNotFoundException;
import fourstacks.vanguard.demo.domain.customer.model.Customer;
import fourstacks.vanguard.demo.domain.customer.repo.CustomerRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {
    private static Logger logger = LoggerFactory.getLogger(CustomerServiceImpl.class);
    private CustomerRepo customerRepo;

    @Autowired
    public CustomerServiceImpl(CustomerRepo customerRepo){
        this.customerRepo=customerRepo;
    }

    @Override
    public Customer create(Customer customer) {
        return customerRepo.save(customer);
    }

    @Override
    public Customer getById(Long id) throws CustomerNotFoundException {
        Optional<Customer> customerOptional = customerRepo.findById(id);
        if(customerOptional.isEmpty())
            throw new CustomerNotFoundException("Customer doesn't exist");
        return customerOptional.get();
    }

    @Override
    public Customer getByFullName(String firstName, String lastName) throws CustomerNotFoundException {
        Optional<Customer> customerOptional = customerRepo.findByFirstAndLastName(firstName, lastName);
        if (customerOptional.isEmpty())
            throw new CustomerNotFoundException("Customer not found");
        return customerOptional.get();
    }

    @Override
    public Customer update(Customer customer) throws CustomerNotFoundException {
        Long id = customer.getId();
        Optional<Customer> customerOptional= customerRepo.findById(id);
        if (customerOptional.isEmpty())
            throw new CustomerNotFoundException("Customer not found");
        return customerRepo.save(customer);
    }

    @Override
    public void delete(Long id) throws CustomerNotFoundException {
        Optional<Customer> customerOptional = customerRepo.findById(id);
        if(customerOptional.isEmpty())
            throw new CustomerNotFoundException("Customer not found");
        customerRepo.delete(customerOptional.get());
    }

    @Override
    public Iterable<Customer> findAll() {
        return customerRepo.findAll();
    }

}