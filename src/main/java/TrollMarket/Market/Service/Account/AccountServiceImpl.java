package TrollMarket.Market.Service.Account;

import TrollMarket.Market.ApplicationUserDetails;
import TrollMarket.Market.Cofiguration.MvcSecurityConfig;
import TrollMarket.Market.Dto.AdminDto;
import TrollMarket.Market.Dto.ProfilDto;
import TrollMarket.Market.Dto.RegisterDto;
import TrollMarket.Market.Entity.Account;
import TrollMarket.Market.Entity.Buyer;
import TrollMarket.Market.Entity.Seller;
import TrollMarket.Market.ExeptionHandeler.SomethingWrong;
import TrollMarket.Market.Repository.AccountRepository;
import TrollMarket.Market.Repository.BuyerRepository;
import TrollMarket.Market.Repository.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Optional;

@Service
@Transactional
public class AccountServiceImpl implements AccountService, UserDetailsService {

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    BuyerRepository buyerRepository;

    @Autowired
    SellerRepository sellerRepository;

    @Override
    public void registerAccount(RegisterDto registerDto) {
    PasswordEncoder passwordEncoder = MvcSecurityConfig.passwordEncoder();
    String hasPassword = passwordEncoder.encode(registerDto.getPassword());

        //SAVE ACCOUNT
        Account account = new Account(
                registerDto.getUsername(),
                hasPassword,
                registerDto.getRole()
        );
        accountRepository.save(account);
        //SAVE BUYER
        Account newAccount = accountRepository.findByUserName(registerDto.getUsername());
        if (registerDto.getRole().equals("Buyer")){
            Buyer buyer = new Buyer(
                    registerDto.getFirstName(),
                    registerDto.getLastName(),
                    registerDto.getAddress(),
                    registerDto.getPhoneNUmber(),
                    newAccount
            );
            buyerRepository.save(buyer);

        //SAVE SELLER
        } else if (registerDto.getRole().equals("Seller")) {
            Seller seller = new Seller(
                    registerDto.getFirstName(),
                    registerDto.getLastName(),
                    registerDto.getAddress(),
                    registerDto.getPhoneNUmber(),
                    newAccount
            );
            sellerRepository.save(seller);
        }else {
            throw new SomethingWrong("Something went wrong, please try again");
        }
    }

    @Override
    public void registerAccountAdmin(AdminDto adminDto) {
        PasswordEncoder passwordEncoder = MvcSecurityConfig.passwordEncoder();
        String hasPassword = passwordEncoder.encode(adminDto.getPassword());
        try {
            Account account = new Account(
                    adminDto.getUsername(),
                    hasPassword,
                    adminDto.getRole());
            accountRepository.save(account);
        }catch (Exception e){
            throw new SomethingWrong("Something went wrong, please try again");
        }

    }


    @Override
    public ProfilDto getUserProfile(String username) {
        Account account = accountRepository.findByUserName(username);

        if (account.getRole().equals("Buyer")){
            Buyer buyer = buyerRepository.findByAccount_UserName(account.getUserName());
            String balance = NumberFormat.getNumberInstance(new Locale("id","ID")).format((double) buyer.getWallet());
            ProfilDto profilDto = new ProfilDto(buyer.getFirstName() ,buyer.getLastName(),account.getRole(), buyer.getAddress(), balance);
            return profilDto;

        } else if (account.getRole().equals("Seller")) {
            Seller seller = sellerRepository.findByAccount_UserName(account.getUserName());
            String balance = NumberFormat.getNumberInstance(new Locale("id","ID")).format((double)seller.getWallet());
            ProfilDto profilDto = new ProfilDto(seller.getFirstName(),seller.getLastName(),account.getRole(),seller.getAddress(),balance);
            return profilDto;

        }else {

            return null;
        }
    }

    @Override
    public String getAccountRole(String userName) {
        Optional<Account> accountOptional = accountRepository.findById(userName);
        Account tempAccount= null;
        if (accountOptional.isPresent()) {
            tempAccount = accountOptional.get();
        }
        return tempAccount.getRole();
    }

    @Override
    public Boolean cekExistingAccount(String userName) {
        return this.accountRepository.existsAccountByUserName(userName);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Account> optionalAccount =accountRepository.findById(username);
        Account tempAccount = null;
        if (optionalAccount.isPresent()){
            tempAccount =optionalAccount.get();
        }
        return new ApplicationUserDetails(tempAccount);
    }
}
