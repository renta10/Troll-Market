package TrollMarket.Market.Service.Shipment;

import TrollMarket.Market.Dto.ShipmentDto;
import TrollMarket.Market.Dto.ShipmentDtoShow;
import TrollMarket.Market.Entity.Shipment;
import TrollMarket.Market.ExeptionHandeler.NotAllowed;
import TrollMarket.Market.ExeptionHandeler.SomethingWrong;
import TrollMarket.Market.Repository.ShipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShipmentImpl implements ShipmentService {

    @Autowired
    ShipmentRepository shipmentRepository;


    @Override
    public void save(ShipmentDto shipmentDto) {
        try {
            Shipment shipment = new Shipment(
                    shipmentDto.getId(),
                    shipmentDto.getShipmentName(),
                    shipmentDto.getPrice(),
                    shipmentDto.isService()
            );
            shipmentRepository.save(shipment);
        }catch (Exception e){
            throw new SomethingWrong("Something wrong ");
        }
    }

    @Override
    public List<ShipmentDtoShow> shipmentShow() {
        return shipmentRepository.findAllShimpment();
    }

    @Override
    public void deleteByid(Integer id) {
        try{
            shipmentRepository.deleteById(id);
        }catch (Exception e){
            throw new SomethingWrong("theres no id with id "+ id);
        }
    }

    @Override
    public Optional<Shipment> findbyId(Integer id) {
        return Optional.ofNullable(shipmentRepository.findById(id).orElseThrow(() -> {
            throw new NotAllowed("There's no Shipment With ID" + id);
        }));
    }

}
