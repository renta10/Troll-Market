package TrollMarket.Market.Repository;

import TrollMarket.Market.Entity.Chart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Chart,Integer> {
}
