package TrollMarket.Market.Controller;

import TrollMarket.Market.Dto.ProfilDto;
import TrollMarket.Market.Service.Account.AccountService;
import TrollMarket.Market.Service.Buyer.BuyerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;

@Controller
@RequestMapping("/profile")
public class ProfileController {

    @Autowired
    private AccountService accountService;

    @Autowired
    private BuyerService buyerService;

    @GetMapping("/showProfile")
    public String getProfile(Principal principal, Model model){
       ProfilDto profilDto = accountService.getUserProfile(principal.getName());
       model.addAttribute("user",profilDto);
       return"/Profile/profilePage";
    }

    @PostMapping("/addBalance")
    public String addBalance(@RequestParam String addbalances, Principal principal ){
        Double doubleAddbalance = 0.0d;
        doubleAddbalance = Double.valueOf(addbalances);
        buyerService.addBalance(principal.getName(),doubleAddbalance);
        return "redirect:/profile/showProfile";
    }

}
