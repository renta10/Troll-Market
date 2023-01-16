package TrollMarket.Market.Service.Seller;

import TrollMarket.Market.Dto.SellerDtoShow;
import TrollMarket.Market.Entity.Seller;

import java.util.List;

public interface SellerService {

    List<SellerDtoShow>showSeller();
    Seller findByid(Integer id);
    void deleteById(Integer id);
}
