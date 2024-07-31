package hmayda.abdessamad.customerservice;

import hmayda.abdessamad.customerservice.entities.Customer;
import hmayda.abdessamad.customerservice.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }


    @Bean
    public CommandLineRunner commandLineRunner(CustomerRepository customerRepository) {
        return args -> {
            // Create a list of customers
            List<Customer> customers = Arrays.asList(
                    Customer.builder().firstNamr("Hmayda").lastName("Abdessamad").email("me@gmail.com").build(),
                    Customer.builder().firstNamr("Aicha").lastName("Benali").email("you@gmail.com").build()
                    // Add more customers here...
            );
            // Save all customers to the repository
            customerRepository.saveAll(customers);
        };
    }


}
