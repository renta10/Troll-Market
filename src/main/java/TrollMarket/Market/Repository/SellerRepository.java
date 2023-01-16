package TrollMarket.Market.Repository;

import TrollMarket.Market.Dto.ProfilDto;
import TrollMarket.Market.Dto.SellerDtoShow;
import TrollMarket.Market.Entity.Seller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SellerRepository extends JpaRepository<Seller,Integer> {

    @Query("""
    SELECT new TrollMarket.Market.Dto.SellerDtoShow(sel.id,
    sel.firstName,sel.lastName,sel.address,sel.phoneNUmber,sel.wallet
    )FROM Seller sel
    """)
    public List<SellerDtoShow>findAllWithDto();

    Seller findByAccount_UserName(String username);
}
