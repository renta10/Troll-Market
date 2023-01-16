package TrollMarket.Market.ExeptionHandeler;

import org.springframework.security.core.AuthenticationException;

public class AuthenticationFailure extends AuthenticationException {
    public AuthenticationFailure(String massage) {
        super(massage);
    }
}
