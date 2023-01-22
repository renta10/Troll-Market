package TrollMarket.Market.Service.Chart;

import TrollMarket.Market.Dto.CartDto;
import TrollMarket.Market.Dto.CartDtoShow;


import java.util.List;

public interface CartService {
    void save(CartDto cartDto, String username );
    List<CartDtoShow>cartDtoShow();
    void deleteCart(Integer id);
    void puchesAll(String name);


}
