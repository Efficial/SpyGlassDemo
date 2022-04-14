package fourstacks.vanguard.demo.domain.customer.model;

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
    private List<Goal> goal;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
