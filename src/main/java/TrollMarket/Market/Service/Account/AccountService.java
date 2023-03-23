package TrollMarket.Market.Service.Account;

import TrollMarket.Market.Dto.AdminDto;
import TrollMarket.Market.Dto.ProfilDto;
import TrollMarket.Market.Dto.RegisterDto;
import org.springframework.security.core.userdetails.UserDetails;

public interface AccountService {
    void registerAccount(RegisterDto registerDto) ;
    void registerAccountAdmin(AdminDto adminDto);
    ProfilDto getUserProfile(String username)throws Exception;
    UserDetails loadUserByUsername(String username);
    String getAccountRole(String userName);
    Boolean cekExistingAccount(String userName);
}
