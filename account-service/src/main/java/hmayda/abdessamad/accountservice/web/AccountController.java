package hmayda.abdessamad.accountservice.web;

import hmayda.abdessamad.accountservice.clients.CustomerRestClient;
import hmayda.abdessamad.accountservice.entities.Account;
import hmayda.abdessamad.accountservice.models.Customer;
import hmayda.abdessamad.accountservice.repository.AccountRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/accounts")
public class AccountController {

    private final AccountRepository accountRepository;
    private final CustomerRestClient customerRestClient;

    public AccountController(AccountRepository accountRepository,CustomerRestClient customerRestClient) {
        this.accountRepository = accountRepository;
        this.customerRestClient=customerRestClient;
    }

    @GetMapping
    public List<Account> accountList(){
        List<Account> accountList=this.accountRepository.findAll();
        accountList.forEach(account -> {
            account.setCustomer(customerRestClient.findCustomerById(account.getCustomerId()));
        });
        return this.accountRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Account> accountById(@PathVariable String id){

        Account account=this.accountRepository.findById(id).get();
        Customer customer=customerRestClient.findCustomerById(account.getCustomerId());
        account.setCustomer(customer);
        return ResponseEntity.ok(account);
    }


}
