package TrollMarket.Market.Controller;

import TrollMarket.Market.Dto.ShipmentDto;
import TrollMarket.Market.Dto.ShipmentDtoShow;
import TrollMarket.Market.Repository.ShipmentRepository;
import TrollMarket.Market.Service.Shipment.ShipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@Controller
@RequestMapping("/shipment")
public class ShipmentController {

    @Autowired
    ShipmentService shipmentService;


    @GetMapping("/addShipment")
    public String addShimpmet(Model model){
        ShipmentDto shipmentDto = new ShipmentDto();
        model.addAttribute("shipment",shipmentDto);
        return "Shipment/addShipment";
    }

    @PostMapping("/saveShipment")
    public String saveShipment(@ModelAttribute("shipment")ShipmentDto shipmentDto){
        shipmentService.save(shipmentDto);
        return "redirect:/shipment/showShipment";
    }

    @GetMapping("/showShipment")
    public String ShowShipment(Model model){
        List<ShipmentDtoShow> shipmentDtoShow = shipmentService.shipmentShow();
        model.addAttribute("shipmentShow",shipmentDtoShow);
        return "/Shipment/showShipment";
    }

    @GetMapping("/editShipment")
    public String editShipment(@RequestParam Integer id, Model model){
        model.addAttribute("shipment",shipmentService.findbyId(id));
        return "Shipment/addShipment";
    }

    @GetMapping("/deleteShipment")
    public String deleteShipment(@RequestParam Integer id){
        shipmentService.deleteByid(id);
        return "redirect:/shipment/showShipment";
    }

}
