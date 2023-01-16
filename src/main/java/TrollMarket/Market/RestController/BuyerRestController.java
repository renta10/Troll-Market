//package TrollMarket.Market.RestController;
//
//import TrollMarket.Market.Dto.BuyerDto;
//import TrollMarket.Market.Dto.BuyerDtoShow;
//import TrollMarket.Market.Entity.Buyer;
//import TrollMarket.Market.Service.Buyer.BuyerService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import javax.validation.Valid;
//import java.util.List;
//
//@RestController
//@RequestMapping("api/buyers")
//public class BuyerRestController {
//
//    @Autowired
//    BuyerService buyerService;
//
//
//    @PostMapping
//    public ResponseEntity<String> addBuyer(@RequestBody BuyerDto buyerDto){
//        buyerService.saveBuyer(buyerDto);
//        return new ResponseEntity<>("Data Berhasi di input", HttpStatus.OK);
//    }
//
//    @GetMapping
//    public ResponseEntity<List<BuyerDtoShow>>showAllBuyer(){
//        List<BuyerDtoShow> buyerDtoShows = buyerService.showBuyerDto();
//        return new ResponseEntity<>(buyerDtoShows,HttpStatus.OK);
//    }
//
//    @PutMapping
//    public ResponseEntity<String> updateBuyer(@RequestBody BuyerDto buyerDto){
//        buyerService.saveBuyer(buyerDto);
//        return new ResponseEntity<>("Data Berhasi di di update", HttpStatus.OK);
//    }
//
//
//    @GetMapping({"/{id}"})
//    public ResponseEntity<Buyer>findById(@Valid @PathVariable("id")Integer id){
//        Buyer buyer = buyerService.findByid(id);
//        return new ResponseEntity<>(buyer, HttpStatus.OK);
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<String>deleteById(@PathVariable("id")Integer id){
//        buyerService.deleteById (id);
//        return new ResponseEntity<>("data berhasil di hapus",HttpStatus.OK);
//    }
//}
