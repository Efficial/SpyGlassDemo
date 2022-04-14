package fourstacks.vanguard.demo.domain.customer.service;

import fourstacks.vanguard.demo.domain.customer.exceptions.CustomerNotFoundException;
import fourstacks.vanguard.demo.domain.customer.model.Customer;

public class CustomerServiceImpl implements CustomerService {
    @Override
    public Customer create(Customer customer) {
        return null;
    }

    @Override
    public Customer getById(Long id) throws CustomerNotFoundException {
        return null;
    }

    @Override
    public Customer getByFullName(String firstName, String lastName) throws CustomerNotFoundException {
        return null;
    }

    @Override
    public Customer update(Customer customer) throws CustomerNotFoundException {
        return null;
    }

    @Override
    public void delete(String firstName, String lastName) throws CustomerNotFoundException {

    }
}
