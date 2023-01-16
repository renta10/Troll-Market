//package TrollMarket.Market.RestController;
//
//import TrollMarket.Market.Dto.SellerDto;
//import TrollMarket.Market.Dto.SellerDtoShow;
//import TrollMarket.Market.Entity.Seller;
//import TrollMarket.Market.Service.Seller.SellerService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import javax.validation.Valid;
//import java.util.List;
//
//@RestController
//@RequestMapping("api/sellers")
//public class SellerRestController {
//
//    @Autowired
//    SellerService sellerService;
//
//    @PostMapping
//    public ResponseEntity<String> addSeller(@RequestBody SellerDto sellerDto){
//     sellerService.saveSeller(sellerDto);
//     return new ResponseEntity<>("Data Berhasi di di di input", HttpStatus.OK);
//    }
//
//    @GetMapping
//    public ResponseEntity<List<SellerDtoShow>>showAllSeller(){
//        List<SellerDtoShow> sellerDtoShows = sellerService.showSeller();
//        return new ResponseEntity<>(sellerDtoShows,HttpStatus.OK);
//    }
//
//    @GetMapping({"/{id}"})
//    public ResponseEntity<Seller>findById(@Valid @PathVariable("id")Integer id){
//        Seller seller = sellerService.findByid(id);
//        return new ResponseEntity<>(seller, HttpStatus.OK);
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<String>deleteById(@PathVariable("id")Integer id){
//        sellerService.deleteById(id);
//        return new ResponseEntity<>("data berhasil di hapus",HttpStatus.OK);
//    }
//
//
//}
