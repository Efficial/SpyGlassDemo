package fourstacks.vanguard.demo.domain.customer.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.ArrayList;

@Entity
public class Goal {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String goalDescription;
    private ArrayList<GoalMilestone> goalMilestones;

    public Goal() {
    }

    public String getGoalDescription() {
        return goalDescription;
    }

    public void setGoalDescription(String goalDescription) {
        this.goalDescription = goalDescription;
    }

    public ArrayList<GoalMilestone> getGoalMilestones() {
        return goalMilestones;
    }

    public void setGoalMilestones(ArrayList<GoalMilestone> goalMilestones) {
        this.goalMilestones = goalMilestones;
    }

    @Override
    public String toString() {
        return "Goal{" +
                "goalDescription='" + goalDescription + '\'' +
                ", goalMilestones=" + goalMilestones +
                '}';
    }
}