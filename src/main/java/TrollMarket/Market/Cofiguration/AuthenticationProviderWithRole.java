package TrollMarket.Market.Cofiguration;

import TrollMarket.Market.ExeptionHandeler.AuthenticationFailure;
import TrollMarket.Market.Service.Account.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import javax.servlet.http.HttpServletRequest;

//ini merupakan class Authentication Custom yang di gunakan untuk mengecek role pada saat log in

@Component
public class AuthenticationProviderWithRole implements AuthenticationProvider {

    @Autowired
    private AccountService accountService;

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        UserDetails userDetails;
        try{
            userDetails = accountService.loadUserByUsername(authentication.getName());
        }catch (RuntimeException e){
            throw new AuthenticationFailure("Username Doesn't Exist ");
        }

        if (!userDetails.getAuthorities().toArray()[0].toString().equals(request.getParameter("role"))) { //"role" sesuaikan pada html di login page pada "name"
            throw new AuthenticationFailure("Username with chosen role doesn't exist");
        }

        if (!passwordEncoder.matches(authentication.getCredentials().toString(), userDetails.getPassword())) {
            throw new AuthenticationFailure("Invalid Password");
        }
        return new UsernamePasswordAuthenticationToken(authentication.getName(), authentication.getCredentials(), userDetails.getAuthorities());
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
