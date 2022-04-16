package fourstacks.vanguard.demo.domain.goal.model;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
public class Goal {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private GoalType goalType;
    private String goalDescription;

    @OneToMany(targetEntity = GoalMilestone.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    @JoinColumn(name = "goalId", referencedColumnName = "id")
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
                "id=" + id +
                ", goalType=" + goalType +
                ", goalDescription='" + goalDescription + '\'' +
                ", goalMilestones=" + goalMilestones +
                '}';
    }
}