package hmayda.abdessamad.accountservice;

import hmayda.abdessamad.accountservice.clients.CustomerRestClient;
import hmayda.abdessamad.accountservice.config.GlobalConfig;
import hmayda.abdessamad.accountservice.entities.Account;
import hmayda.abdessamad.accountservice.enums.AccountType;
import hmayda.abdessamad.accountservice.repository.AccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@SpringBootApplication
@EnableConfigurationProperties({GlobalConfig.class,})
@EnableFeignClients
public class AccountServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountServiceApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AccountRepository accountRepository, CustomerRestClient customerRestClient) {
		return args -> {
				customerRestClient.allCustomers().forEach(c->
						{
							Account account1=Account.builder().Id(UUID.randomUUID().toString()).balance(50.2d).accountType(AccountType.CURRENT_Account).currency("DH").createdaAt(LocalDateTime.now()).customerId(c.getId()).build();
							Account account2=Account.builder().Id(UUID.randomUUID().toString()).balance(50.2d).accountType(AccountType.SAVING_ACCOUNT).currency("DH").createdaAt(LocalDateTime.now()).customerId(c.getId()).build();
							List<Account> customerAccounts= List.of(account1,account2);
							accountRepository.saveAll(customerAccounts);
						}
						);


		};
	}
}
