package TrollMarket.Market.Validasi;

import TrollMarket.Market.Service.Account.AccountService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqValidatorImpl implements ConstraintValidator<UniqValidator,String> {

    private final AccountService accountService;

    @Autowired
    public UniqValidatorImpl(AccountService accountService) {
        this.accountService = accountService;
    }


    @Override
    public boolean isValid(String username, ConstraintValidatorContext context) {
        return !this.accountService.cekExistingAccount(username);
    }
}
