package TrollMarket.Market.Repository;

import TrollMarket.Market.Entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Integer> {
}
