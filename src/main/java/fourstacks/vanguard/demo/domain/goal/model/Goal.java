package fourstacks.vanguard.demo.domain.goal.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.ArrayList;

@Entity
public class Goal {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private GoalType goalType;
    private String goalDescription;
    private ArrayList<GoalMilestone> goalMilestones;

    public Goal() {
    }

    public Goal(String goalDescription, ArrayList<GoalMilestone> goalMilestones, Goal ) {
        this.goalDescription = goalDescription;
        this.goalMilestones = goalMilestones;}



}