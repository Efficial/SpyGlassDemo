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

    public Goal(String goalDescription, ArrayList<GoalMilestone> goalMilestones, GoalType goalType) {
        this.goalDescription = goalDescription;
        this.goalMilestones = goalMilestones;
        this.goalType = goalType;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public GoalType getGoalType() {
        return goalType;
    }

    public void setGoalType(GoalType goalType) {
        this.goalType = goalType;
    }

    public String getGoalDescription() {
        return goalDescription;
    }

    public void setGoalDescription(String goalDescription) {
        this.goalDescription = goalDescription;
        this.goalMilestones = goalMilestones;}


    @Override
    public String toString() {
        return "Goal{" +
                "id=" + id +
                ", goalType=" + goalType +
                ", goalDescription='" + goalDescription + '\'' +
                ", goalMilestones=" + goalMilestones +
                '}';
    }
}