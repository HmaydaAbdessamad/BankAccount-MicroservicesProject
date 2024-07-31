package hmayda.abdessamad.accountservice.models;


import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Customer {

    private long id;
    private String firstNamr;
    private String lastName;
    private String email;
}
