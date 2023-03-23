package TrollMarket.Market.RestController;

import TrollMarket.Market.Dto.ProfilDto;
import TrollMarket.Market.Service.Account.AccountService;
import TrollMarket.Market.Service.Buyer.BuyerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("api/profile")
public class ProfileRestController {

    @Autowired
    private AccountService accountService;

    @Autowired
    private BuyerService buyerService;

    @GetMapping(value = "/profile", headers = "Authorization")
    public ResponseEntity<ProfilDto>getProfil(Principal principal)throws Exception{
            ProfilDto profilDto = accountService.getUserProfile(principal.getName());
            return new ResponseEntity<>(profilDto, HttpStatus.OK);

    }
}
