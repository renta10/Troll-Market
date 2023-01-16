package TrollMarket.Market.Controller;

import TrollMarket.Market.Dto.ProductDto;
import TrollMarket.Market.Dto.ProductDtoshow;
import TrollMarket.Market.Service.Product.ProductService;
import TrollMarket.Market.Service.Seller.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/merchandise")
public class MerchandiseController {

    @Autowired
    ProductService productService;

    @Autowired
    SellerService sellerService;

    @GetMapping("/addProduct")
    public String addProduct(Model model ){
        ProductDto productDto = new ProductDto();
        model.addAttribute("addProduct",productDto);
        return "/Merchandise/merchandise";
    }

    @PostMapping("/saveProduct")
    public String saveProduct(@ModelAttribute("addProduct")ProductDto productDto,Principal principal){
        productService.saveProduct(productDto,principal.getName());
        return "redirect:/merchandise/showProduct";
    }

    @GetMapping("/editProduct")
    public String editProduct(@RequestParam Integer id, Model model){
        model.addAttribute("addProduct",this.productService.findByid(id));
        return "/Merchandise/merchandise";
    }

    @GetMapping("/showProduct")
    public String showProduct(Model model, Principal principal){
        List<ProductDtoshow>productDtoshows = productService.findProductByAccount(principal.getName());
        model.addAttribute("showProduct",productDtoshows);
        return "/Merchandise/showProduct";
    }

    @GetMapping("/deleteProduct")
    public String deleteProduct(@RequestParam Integer id, Principal principal){
        productService.deleteById(id, principal.getName());
        return "redirect:/merchandise/showProduct";
    }

    @GetMapping("/infoProduct")
    @ResponseBody
    public ProductDtoshow infoProduct(@RequestParam Integer id){
        ProductDtoshow productDtoshow = productService.findProductById(id);
        return productDtoshow;
    }


}
