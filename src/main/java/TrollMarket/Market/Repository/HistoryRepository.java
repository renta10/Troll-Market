package TrollMarket.Market.Repository;

import TrollMarket.Market.Entity.History;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HistoryRepository extends JpaRepository<History,Integer> {
}
