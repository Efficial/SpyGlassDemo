package fourstacks.vanguard.demo.domain.goal.repo;

import fourstacks.vanguard.demo.domain.goal.model.Goal;
import org.springframework.data.repository.CrudRepository;

public interface GoalRepo  extends CrudRepository<Goal, Long> {
}
