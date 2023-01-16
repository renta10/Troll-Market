package TrollMarket.Market.Service.Seller;

import TrollMarket.Market.Dto.SellerDtoShow;
import TrollMarket.Market.Entity.Seller;
import TrollMarket.Market.ExeptionHandeler.NotAllowed;
import TrollMarket.Market.Repository.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SellerServiceImpl implements SellerService{

    @Autowired
    SellerRepository sellerRepository;

    @Override
    public List<SellerDtoShow> showSeller() {
        return sellerRepository.findAllWithDto();

    }

    @Override
    public Seller findByid(Integer id) {
        return sellerRepository.findById(id).orElseThrow(()->{
            throw new NotAllowed("There's no Seller With ID" + id);

        });
    }

    @Override
    public void deleteById(Integer id) {
        sellerRepository.deleteById(id);
    }


}
