package fourstacks.vanguard.demo.domain.expense.repo;

import fourstacks.vanguard.demo.domain.expense.model.Expense;
import org.springframework.data.repository.CrudRepository;

public interface ExpenseRepo extends CrudRepository<Expense, Long> {

}
