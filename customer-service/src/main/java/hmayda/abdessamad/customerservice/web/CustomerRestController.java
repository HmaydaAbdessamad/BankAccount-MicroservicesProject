package hmayda.abdessamad.customerservice.web;

import hmayda.abdessamad.customerservice.entities.Customer;
import hmayda.abdessamad.customerservice.repository.CustomerRepository;

import lombok.AllArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor // used for depency injection , we remove it by creating  a constructor with repo as a param
@RequestMapping("/customers")
public class CustomerRestController {

    private CustomerRepository customerRepository;

    @GetMapping
    public List<Customer> customerList(){
        return this.customerRepository.findAll();
    }



    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable Long id) {
        Optional<Customer> customer = customerRepository.findById(id);
        return customer.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

     /*
    @GetMapping("/{id}")
    public Customer getCustomerById(@PathVariable Long id) {
        return customerRepository.findById(id).orElseThrow(() -> new NotFoundException("Customer not found with id:" + id));
    }

    */


}
