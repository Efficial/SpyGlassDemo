package fourstacks.vanguard.demo.domain.customer.repo;

import fourstacks.vanguard.demo.domain.customer.model.Customer;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CustomerRepo extends CrudRepository<Customer, Long> {
<<<<<<< HEAD
    Optional<Customer> findByFirstAndLastName(String firstName, String lastName);
=======
    Optional<Customer> findByFirstandLastName(String firstName, String lastName);
    Optional<Customer> findByUserName(String userName);
>>>>>>> 332d2ac482a7f4455a415479cd147342ae8b0623
}
