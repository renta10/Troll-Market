package TrollMarket.Market.RestController;

import TrollMarket.Market.Service.Product.ProductService;
import TrollMarket.Market.Service.Seller.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/merchandise")
public class MerchandiseRestController {

    @Autowired
    ProductService productService;

    @Autowired
    SellerService sellerService;

}
