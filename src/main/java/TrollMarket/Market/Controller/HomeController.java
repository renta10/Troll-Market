package TrollMarket.Market.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping("/home")
public class HomeController {
    @GetMapping("/homePage")
    public String homePage(){
        return "Home/homePage";
    }
}
