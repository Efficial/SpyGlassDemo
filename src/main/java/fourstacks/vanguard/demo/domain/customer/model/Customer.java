package fourstacks.vanguard.demo.domain.customer.model;


import fourstacks.vanguard.demo.domain.goal.model.Goal;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String firstName;
    private String lastName;
    private Long accountNum;
    private String userName;
    private String password;
    private Date dateOfBirth;
    private String aboutMe;
    private String photo;

//    @OneToMany(targetEntity = Expense.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
//    @JoinColumn(name = "customerId", referencedColumnName = "id")
//    private List<Expense> expenses;


    @OneToMany(targetEntity = Goal.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    @JoinColumn(name = "customerId", referencedColumnName = "id")
    private List<Goal> goals;

    public Customer() {
    }

    public Customer(String firstName, String lastName, Long accountNum,
                    String userName,
                    String password,
                    Date dateOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.accountNum = accountNum;
        this.userName = userName;
        this.password = password;
        this.dateOfBirth = dateOfBirth;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Long getAccountNum() {
        return accountNum;
    }

    public void setAccountNum(Long accountNum) {
        this.accountNum = accountNum;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAboutMe() {
        return aboutMe;
    }

    public void setAboutMe(String aboutMe) {
        this.aboutMe = aboutMe;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public List<Goal> getGoals() {
        return goals;
    }

    public void setGoals(List<Goal> goals) {
        this.goals = goals;
    }

//    public List<Expense> getExpenses() {
//        return expenses;
//    }
//
//    public void setExpenses(List<Expense> expenses) {
//        this.expenses = expenses;
//    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", accountNum=" + accountNum +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", aboutMe='" + aboutMe + '\'' +
                ", photo='" + photo + '\'' +
                ", goals=" + goals +
//                ", expenses=" + expenses +
                '}';
    }
}