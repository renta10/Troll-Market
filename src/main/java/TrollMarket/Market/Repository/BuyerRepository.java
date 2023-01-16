package TrollMarket.Market.Repository;

import TrollMarket.Market.Dto.BuyerDtoShow;
import TrollMarket.Market.Entity.Buyer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BuyerRepository extends JpaRepository<Buyer,Integer> {
    @Query("""
    SELECT new TrollMarket.Market.Dto.BuyerDtoShow
    (concat(buy.firstName,' ',buy.lastName),buy.address,buy.phoneNUmber, buy.wallet )
    FROM Buyer as buy
    """)
    public List<BuyerDtoShow>buyerShowAll();

    Buyer findByAccount_UserName(String Username);

}
