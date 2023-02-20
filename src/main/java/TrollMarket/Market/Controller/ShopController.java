package TrollMarket.Market.Controller;
import TrollMarket.Market.Dto.CartDto;
import TrollMarket.Market.Dto.ProductDtoshow;
import TrollMarket.Market.Dto.ShipmentDtoShow;
import TrollMarket.Market.Repository.ProductRepository;
import TrollMarket.Market.Repository.SellerRepository;
import TrollMarket.Market.Service.Product.ProductService;
import TrollMarket.Market.Service.Shipment.ShipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/shop")
public class ShopController {

    @Autowired
    SellerRepository sellerRepository;

    @Autowired
    ProductService productService;

    @Autowired
    private ShipmentService shipmentService;


    //penjelasan
    //defaultValue = "" (String kosong pada data pasti ada makanya digunakan defaultValue = "" supaya data
    //muncul pada client side

    @GetMapping("/shopIndex")
    public String Shop(@RequestParam(value = "key1", defaultValue = "") String keySearch1, @RequestParam(value = "key2",defaultValue = "") String keySearch2, @RequestParam(value = "key3",defaultValue = "") String keySearch3, Model model){
        CartDto cartDto = new CartDto();
        List<ProductDtoshow> productDtoshowList = productService.findAllProduct(keySearch1,keySearch2,keySearch3);
        List<ShipmentDtoShow>shipmentDtoShows = shipmentService.shipmentShow();
        model.addAttribute("allProduct",productDtoshowList);
        model.addAttribute("shipment",shipmentDtoShows);
        model.addAttribute("cart",cartDto);
        return "Shop/shop";
    }


//    @GetMapping("/searchProduct")
//    public String productList(@RequestParam("key1") String keySearch1,@RequestParam("key2") String keySearch2,@RequestParam("key3") String keySearch3,  Model model ){
//        List<Product>productList = productService.findByCategoryOrProductNameOrDescription(keySearch1, keySearch2, keySearch3);
//        model.addAttribute("allProduct",productList);
//        return "Shop/shop";
//    }


}
