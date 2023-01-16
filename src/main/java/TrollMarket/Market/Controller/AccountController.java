package TrollMarket.Market.Controller;

import TrollMarket.Market.Dto.AdminDto;
import TrollMarket.Market.Dto.RegisterDto;
import TrollMarket.Market.Service.Account.AccountService;
import TrollMarket.Market.Service.Buyer.BuyerService;
import TrollMarket.Market.Service.Seller.SellerService;
import TrollMarket.Market.Utility.Dropdown;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    AccountService accountService;

    @Autowired
    BuyerService buyerService;

    @Autowired
    SellerService sellerService;


    @GetMapping("/addAccount")
    public String register(@RequestParam("role")String role, Model model){
        RegisterDto registerDto = new RegisterDto();
        model.addAttribute("account",registerDto);
        registerDto.setRole(role);
        return "Account/register";

    }

    @GetMapping("/showMyLoginPage")
    public String showMyLoginPage(Model model) {
        List<Dropdown>roleDropdown = Dropdown.getRoleDropdown();
        model.addAttribute("roleDropdown",roleDropdown);
        return "Account/loginPage";
    }


    @PostMapping("/saveAccount")
    public String saveAccount(@Valid @ModelAttribute("account") RegisterDto registerDto /*BindingResult bindingResult*/ ){
        accountService.registerAccount(registerDto);
        return "redirect:/account/showMyLoginPage";
    }


    @GetMapping("/addAccountAdmin")
    public String registerAdmin(@RequestParam("role")String role, Model model){
        AdminDto adminDto = new AdminDto();
        model.addAttribute("admin",adminDto);
        adminDto.setRole(role);
        return "Account/adminRegister";
    }

    @PostMapping("/saveAccountAdmin")
    public String saveAccountAdmin(@Valid @ModelAttribute("account") AdminDto adminDto /*BindingResult bindingResult*/ ){
        accountService.registerAccountAdmin(adminDto);
        return "redirect:/account/showMyLoginPage";
    }

}
