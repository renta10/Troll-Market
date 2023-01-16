package TrollMarket.Market.Repository;

import TrollMarket.Market.Dto.ShipmentDto;
import TrollMarket.Market.Dto.ShipmentDtoShow;
import TrollMarket.Market.Entity.Shipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ShipmentRepository extends JpaRepository<Shipment,Integer> {

    @Query("""
    select new TrollMarket.Market.Dto.ShipmentDtoShow
    (ship.id,ship.shipmentName,ship.price,ship.Service) 
    from Shipment as ship
    """)
    List<ShipmentDtoShow>findAllShimpment();

}
