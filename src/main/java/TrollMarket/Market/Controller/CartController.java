package TrollMarket.Market.Controller;

import TrollMarket.Market.Dto.CartDto;
import TrollMarket.Market.Service.Chart.CartService;
import TrollMarket.Market.Service.Product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller
@RequestMapping("/cart")
public class CartController {

    @Autowired
    CartService cartService;

    @Autowired
    ProductService productService;

    @GetMapping("/addtoCart")
    public String addTOCart(Principal principal,@RequestParam Integer id, Model model){
        CartDto cartDto = new CartDto();
        model.addAttribute("cart",cartDto);
        cartDto.setProductId(id);
        cartDto.setBuyerId(principal.getName());
        return "/Shop/shop";
    }

    @PostMapping("/saveCart")
    public String saveCart(@ModelAttribute("cart") CartDto cartDto, Principal principal){
        cartService.save(cartDto,principal.getName());
        return "redirect:/cart/showMyCart";
    }

    @GetMapping("/showMyCart")
    public String showMyCart(Model model){
        model.addAttribute("MyCart",cartService.cartDtoShow());
        return "/Cart/showMyCart";
    }

    @GetMapping("/delete")
    public String deleteProductFromCart(@RequestParam Integer id){
        cartService.deleteCart(id);
        return "redirect:/cart/showMyCart";
    }

    @GetMapping("/purchesAll")
    public String PurchesAll(Principal principal){
        cartService.puchesAll(principal.getName());
        return "redirect:/cart/showMyCart";
    }

}
