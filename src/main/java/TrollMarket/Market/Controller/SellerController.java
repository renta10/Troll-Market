package TrollMarket.Market.Controller;


import TrollMarket.Market.Dto.SellerDtoShow;
import TrollMarket.Market.Service.Seller.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/seller")
public class SellerController {

    @Autowired
    SellerService sellerService;

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @GetMapping("/showSeller")
    public String showSeller(Model model) {
        List<SellerDtoShow> sellerShow = sellerService.showSeller();
        model.addAttribute("showSeller",sellerShow);
        return "Seller/showSeller";
    }

    @GetMapping("/showSellerById")
    public String UpdateById(@RequestParam int id, Model model) {
        model.addAttribute("authorDto",this.sellerService.findByid(id));
        return "/Author/addOrUpdateAuthor";
    }

}
