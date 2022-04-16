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
<<<<<<< HEAD:src/main/java/fourstacks/vanguard/demo/domain/customer/model/Goal.java
    private GoalType goalType;
=======

>>>>>>> 0b12f0c4d76fe4bb15d71c9d15a6cbd54b709c3d:src/main/java/fourstacks/vanguard/demo/domain/goal/model/Goal.java
    private String goalDescription;
    private GoalType goalType;
    private ArrayList<GoalMilestone> goalMilestones;

    public Goal() {
    }

<<<<<<< HEAD:src/main/java/fourstacks/vanguard/demo/domain/customer/model/Goal.java
    public Goal(String goalDescription, ArrayList<GoalMilestone> goalMilestones) {
        this.goalDescription = goalDescription;
        this.goalMilestones = goalMilestones;
=======
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
>>>>>>> 0b12f0c4d76fe4bb15d71c9d15a6cbd54b709c3d:src/main/java/fourstacks/vanguard/demo/domain/goal/model/Goal.java
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
<<<<<<< HEAD:src/main/java/fourstacks/vanguard/demo/domain/customer/model/Goal.java
                ", goalType=" + goalType +
                ", goalDescription='" + goalDescription + '\'' +
=======
                ", goalDescription='" + goalDescription + '\'' +
                ", goalType=" + goalType +
>>>>>>> 0b12f0c4d76fe4bb15d71c9d15a6cbd54b709c3d:src/main/java/fourstacks/vanguard/demo/domain/goal/model/Goal.java
                ", goalMilestones=" + goalMilestones +
                '}';
    }
}