package fourstacks.vanguard.demo.domain.goal.service;


import fourstacks.vanguard.demo.domain.goal.exceptions.GoalNotFoundException;
import fourstacks.vanguard.demo.domain.goal.model.Goal;
import fourstacks.vanguard.demo.domain.goal.repo.GoalRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class GoalServiceImpl implements GoalService {
    private GoalRepo goalRepo;

    @Autowired
    public GoalServiceImpl(GoalRepo goalRepo){
        this.goalRepo = goalRepo;
    }

    @Override
    public Goal create(Goal goal) {
        return goalRepo.save(goal);
    }

    @Override
    public Goal getById(Long id) throws GoalNotFoundException {
        Optional<Goal> goalOptional = goalRepo.findById(id);
        if(goalOptional.isEmpty())
            throw new GoalNotFoundException("Goal does not exist");
        return goalOptional.get();
    }

    @Override
    public Goal update(Goal goal) throws GoalNotFoundException {
        Long id = goal.getId();
        Optional<Goal> goalOptional= goalRepo.findById(id);
        if (goalOptional.isEmpty())
            throw new GoalNotFoundException("Goal not found");
        return goalRepo.save(goal);
    }

    @Override
    public void delete(Long id) throws GoalNotFoundException {
        Optional<Goal> goalOptional = goalRepo.findById(id);
        if(goalOptional.isEmpty())
            throw new GoalNotFoundException("Goal not found");
        goalRepo.delete(goalOptional.get());
    }

    @Override
    public Iterable<Goal> findAll() throws GoalNotFoundException {
        return goalRepo.findAll();
    }
}
