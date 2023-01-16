package TrollMarket.Market.Service.Buyer;

import TrollMarket.Market.Dto.BuyerDtoShow;
import TrollMarket.Market.Entity.Buyer;
import TrollMarket.Market.ExeptionHandeler.NotAllowed;
import TrollMarket.Market.Repository.BuyerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuyerServiceImpl implements BuyerService{

    @Autowired
    BuyerRepository buyerRepository;


    @Override
    public void addBalance(String name, Double addBalances) {
        Buyer buyer = buyerRepository.findByAccount_UserName(name);
        buyer.setWallet(buyer.getWallet() + addBalances);
        buyerRepository.save(buyer);
    }
}
