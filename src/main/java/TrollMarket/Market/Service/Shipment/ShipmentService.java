package TrollMarket.Market.Service.Shipment;

import TrollMarket.Market.Dto.ShipmentDto;
import TrollMarket.Market.Dto.ShipmentDtoShow;
import TrollMarket.Market.Entity.Shipment;

import java.util.List;
import java.util.Optional;

public interface ShipmentService {

    public void save (ShipmentDto shipmentDto);
    public List<ShipmentDtoShow> shipmentShow();
    public void deleteByid(Integer id);

    public Optional<Shipment> findbyId(Integer id);
}
