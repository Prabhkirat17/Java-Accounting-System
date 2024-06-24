import lombok.Data;
import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;
    private double amount;
    private Date transaction_date;
    private String description;
}
