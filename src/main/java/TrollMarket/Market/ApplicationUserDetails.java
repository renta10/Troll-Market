package TrollMarket.Market;

import TrollMarket.Market.Entity.Account;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ApplicationUserDetails implements UserDetails {

    private String userName;
    private String password;
    private List<GrantedAuthority> authories = new ArrayList<>();

    public ApplicationUserDetails(Account account) {
        this.userName = account.getUserName();
        this.password = account.getPassword();
        this.authories.add(new SimpleGrantedAuthority(account.getRole()));
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authories;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
