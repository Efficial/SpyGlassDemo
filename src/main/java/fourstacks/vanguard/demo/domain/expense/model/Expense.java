package fourstacks.vanguard.demo.domain.expense.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@NoArgsConstructor
@Data
@ToString
@Table(name="expense")
public class Expense {
    @Id
    private Long id;
    @ManyToOne
    private Category category;
    private String description;

}
