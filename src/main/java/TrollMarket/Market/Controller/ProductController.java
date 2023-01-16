//package TrollMarket.Market.Controller;
//
//import TrollMarket.Market.Dto.ProductDto;
//import TrollMarket.Market.Dto.ProductDtoshow;
//import TrollMarket.Market.Service.Product.ProductService;
//import TrollMarket.Market.Service.Seller.SellerService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.propertyeditors.StringTrimmerEditor;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.WebDataBinder;
//import org.springframework.web.bind.annotation.*;
//
//import javax.validation.Valid;
//import java.util.List;
//
//@Controller
//@RequestMapping("/product")
//public class ProductController {
//
//    @Autowired
//    ProductService productService;
//
//    @Autowired
//    SellerService sellerService;
//
//    @InitBinder
//    public void initBinder(WebDataBinder dataBinder) {
//        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
//        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
//    }
//
//    @RequestMapping("/addProduct")
//    public String product(Model model){
//        ProductDto productDto = new ProductDto();
//        model.addAttribute("productDto",productDto);
//        return "Product/productPage";
//    }
//
//
////    @GetMapping("/saveProduct")
////    public String saveProduct(@Valid @ModelAttribute("productDto")ProductDto productDto, BindingResult bindingResult){
////        if (bindingResult.hasErrors()){
////            return "Product/productPage";
////        }
////        productService.saveProduct(productDto);
////        return "redirect:Product/showProduct";
////    }
//
//    @PutMapping("/editProduct")
//    public String editProduct(@RequestParam int id , Model model){
//        model.addAttribute("productDto",this.productService.findByid(id));
//        return "Product/productPage";
//    }
//}
