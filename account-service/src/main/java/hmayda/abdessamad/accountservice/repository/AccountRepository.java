package hmayda.abdessamad.accountservice.repository;

import hmayda.abdessamad.accountservice.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

//@RestResource
@Repository
public interface AccountRepository extends JpaRepository<Account,String> {
}
