package TrollMarket.Market.RestController;

import TrollMarket.Market.Dto.RequestTokenDtio;
import TrollMarket.Market.Dto.ResponTokenDto;
import TrollMarket.Market.Service.Account.AccountService;
import TrollMarket.Market.Utility.JwtToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("api/account")
public class AccountRestController {

    @Autowired
    private AccountService accountService;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtToken jwtToken;

    @PostMapping(value = "/authenticate")
    public ResponTokenDto post(@RequestBody RequestTokenDtio dto){
        try{
            UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(dto.getUsername(), dto.getPassword());
            authenticationManager.authenticate(token);
        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "can't authenticate", e);
        }
        String role = accountService.getAccountRole(dto.getUsername());
        String token = jwtToken.generateToken(dto.getSubject(), dto.getUsername(), dto.getSecretKey(), role, dto.getAudience());
        return new ResponTokenDto(dto.getUsername(), role, token);
    }

}
