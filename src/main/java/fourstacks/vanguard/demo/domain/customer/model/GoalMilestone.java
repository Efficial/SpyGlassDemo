package fourstacks.vanguard.demo.domain.customer.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class GoalMilestone {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Boolean isCompleted;
    private String goalMileStoneDescription;


    public GoalMilestone() {
    }

    public GoalMilestone(Boolean isCompleted, String goalMileStoneDescription) {
        this.isCompleted = isCompleted;
        this.goalMileStoneDescription = goalMileStoneDescription;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getCompleted() {
        return isCompleted;
    }

    public void setCompleted(Boolean completed) {
        isCompleted = completed;
    }

    public String getGoalMileStoneDescription() {
        return goalMileStoneDescription;
    }

    public void setGoalMileStoneDescription(String goalMileStoneDescription) {
        this.goalMileStoneDescription = goalMileStoneDescription;
    }

    @Override
    public String toString() {
        return "GoalMilestone{" +
                "id=" + id +
                ", isCompleted=" + isCompleted +
                ", goalMileStoneDescription='" + goalMileStoneDescription + '\'' +
                '}';
    }
}
