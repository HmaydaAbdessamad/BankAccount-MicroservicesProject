package hmayda.abdessamad.accountservice.entities;

import hmayda.abdessamad.accountservice.enums.AccountType;
import hmayda.abdessamad.accountservice.models.Customer;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Account {

    @Id
    private String Id;
    private double balance;
    private LocalDateTime createdaAt;
    private String currency;
    @Enumerated(EnumType.STRING)
    private AccountType accountType;
    /*
    @Transient
    private Customer customer
     */
    private Long customerId;

    @Transient
    private Customer customer;
}
