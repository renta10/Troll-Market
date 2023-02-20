package TrollMarket.Market.Service.Buyer;

import TrollMarket.Market.Entity.Buyer;
import TrollMarket.Market.Repository.AccountRepository;
import TrollMarket.Market.Repository.BuyerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuyerServiceImpl implements BuyerService{

    @Autowired
    BuyerRepository buyerRepository;
    @Autowired
    private AccountRepository accountRepository;


    @Override
    public void addBalance(String name, String addBalances) {

        if (!addBalances.equals("")) {
            Double doubleAddbalance = 0.0d;
            doubleAddbalance = Double.valueOf(addBalances);
            Buyer buyer = buyerRepository.findByAccount_UserName(name);
            buyer.setWallet(buyer.getWallet() + doubleAddbalance);
            buyerRepository.save(buyer);
        }else {
            throw new RuntimeException("Please enter nominal");
        }
    }
}
