package TrollMarket.Market.Repository;

import TrollMarket.Market.Dto.CartDtoShow;
import TrollMarket.Market.Entity.Chart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CartRepository extends JpaRepository<Chart,Integer> {

//    @Query("""
//    SELECT new TrollMarket.Market.Dto.CartDtoShow(
//    ca.idChart,
//    ca.product.productName,
//    ca.quantity,
//    ca.shipment.shipmentName,
//    ca.product.seller.firstName,
//    FORMAT(((ca.quantity * ca.product.price) + ca.shipment.price)),'c', 'id-ID') from Chart as ca
//    where ca.buyer.account.userName = : username
//    """)
//    public List<CartDtoShow> listCart(String username);

   Optional <Chart> findByProductIdAndBuyer_Account_UserNameAndShipmentId(Integer ProductId ,String username,Integer ShipmentId);
   List<Chart> findByBuyer_AccountUserName(String username);
}
