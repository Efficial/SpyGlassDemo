package fourstacks.vanguard.demo.GoalTest;

import fourstacks.vanguard.demo.domain.goal.exceptions.GoalNotFoundException;
import fourstacks.vanguard.demo.domain.goal.model.Goal;
import fourstacks.vanguard.demo.domain.goal.model.GoalMilestone;
import fourstacks.vanguard.demo.domain.goal.model.GoalType;
import fourstacks.vanguard.demo.domain.goal.repo.GoalRepo;
import fourstacks.vanguard.demo.domain.goal.service.GoalService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import static org.mockito.BDDMockito.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class GoalTest {

    @MockBean
    private GoalRepo goalRepo;

    @Autowired
    private GoalService goalService;

    private ArrayList<GoalMilestone> goalMilestone = new ArrayList<>();
    private GoalType goalType;
    private Goal input;
    private Goal output;

    @BeforeEach
    public void setUp() {
        goalMilestone.add(new GoalMilestone(false, "Pay mortgage"));
        goalMilestone.add(new GoalMilestone(false, "Pay car note"));
        input = new Goal("Complete all Goals", goalMilestone, goalType);
        output = new Goal("Finish all tasks", goalMilestone, goalType);
        output.setId(1L);
    }

    @Test
    @DisplayName("Goal Service create - success")
    public void createGoal(){
        doReturn(output).when(goalRepo).save(ArgumentMatchers.any());
        Goal returnedGoal = goalService.create(input);
        Assertions.assertNotNull(output);
        Assertions.assertEquals(returnedGoal.getId(), 1L);
    }

    @Test
    @DisplayName("Goal Service Find By Id - success")
    public void findGoalByIdTest01() throws GoalNotFoundException {
        doReturn(Optional.of(input)).when(goalRepo).findById(1L);
        Goal foundGoal = goalService.getById(1L);
        Assertions.assertEquals(input.toString(), foundGoal.toString());
    }

    @Test
    @DisplayName("Goal Service findByID - Fail")
    public void findGoalById02(){
        doReturn(Optional.empty()).when(goalRepo).findById(1L);
        Assertions.assertThrows(GoalNotFoundException.class, () ->{
            goalService.getById(1L);
        });
    }

    @Test
    @DisplayName("Goal Service: Get all Goals - Success")
    public void findAllGoalsTest01() throws GoalNotFoundException {
        List<Goal> goals = new ArrayList<>();
        goals.add(input);
        doReturn(goals).when(goalRepo).findAll();
        Iterable<Goal> responseGoal = goalService.findAll();
        Assertions.assertIterableEquals(goals, responseGoal);
    }

    @Test
    @DisplayName("Update Goal - Success")
    public void updateGoalTest01() throws GoalNotFoundException {
        Goal expectedGoalUpdate = new Goal("Complete 75% of goals", goalMilestone, goalType);
        expectedGoalUpdate.setId(1l);
        doReturn(Optional.of(input)).when(goalService).getById(1L);
        doReturn(expectedGoalUpdate).when(goalRepo).save(ArgumentMatchers.any());
        Goal actualGoal = goalService.update(expectedGoalUpdate);
        Assertions.assertEquals(expectedGoalUpdate.toString(), actualGoal.toString());
    }

    @Test
    @DisplayName("Update Goal - Fail")
    public void updateGoalTest02() throws GoalNotFoundException {
        Goal updatedGoal = new Goal("Complete 80% of goals", goalMilestone, goalType);
        doReturn(Optional.empty()).when(goalRepo).findById(1L);
        Assertions.assertThrows(GoalNotFoundException.class, () ->{
            goalService.update(updatedGoal);
        });
    }

    @Test
    @DisplayName("Delete Goal")
    public void deleteGoal(){
        doReturn(Optional.empty()).when(goalRepo).findById(1L);
        Assertions.assertThrows(GoalNotFoundException.class, () ->{
            goalService.delete(1L);
        });
    }
}
