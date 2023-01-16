package TrollMarket.Market.Repository;

import TrollMarket.Market.Entity.Account;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account,String> {

    Account findByUserName(String username);
    boolean existsAccountByUserName(String username);
}
