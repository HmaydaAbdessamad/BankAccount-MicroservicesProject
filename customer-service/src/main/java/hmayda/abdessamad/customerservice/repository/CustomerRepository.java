package hmayda.abdessamad.customerservice.repository;

import hmayda.abdessamad.customerservice.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//@RepositoryRestResource only for POC
@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {


}
