package TrollMarket.Market.Service.Chart;

import TrollMarket.Market.Dto.CartDto;
import TrollMarket.Market.Dto.CartDtoShow;
import TrollMarket.Market.Entity.*;
import TrollMarket.Market.ExeptionHandeler.SomethingWrong;
import TrollMarket.Market.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;


@Service
@Transactional
public class CartImpl implements CartService {
    @Autowired
    BuyerRepository buyerRepository;
    @Autowired
    SellerRepository sellerRepository;
    @Autowired
    CartRepository cartRepository;
    @Autowired
    ShipmentRepository shipmentRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private HistoryRepository historyRepository;

    @Override
    public void save(CartDto cartDto, String username) {
        Buyer buyer = buyerRepository.findByAccount_UserName(username);
        Product product = productRepository.findById(cartDto.getProductId()).get();
        Shipment shipment = shipmentRepository.findById(cartDto.getShipmentId()).get();
        System.out.println(shipment);
        try{
           Chart chart = new Chart(
                   cartDto.getId(),
                    cartDto.getQuantity(),
                    buyer,
                    product,
                    shipment
            );
            System.out.println("masuk");
            System.out.println(shipment);
            cartRepository.save(chart);
        }catch (Exception e){
            throw new SomethingWrong("cannot save this product to cart");
        }
    }

//    @Override
//    public List<CartDtoShow> cartDtoShow(String username) {
//        try{
//            return cartRepository.listCart(username);
//        }catch (Exception e){
//            throw new SomethingWrong("there's no data");
//        }
//    }

    @Override
    public void deleteCart(Integer id) {
        try{
            cartRepository.deleteById(id);
        }catch (Exception e){
            throw new SomethingWrong("cannot delete this product");
        }
    }

    @Override
    public void puchesAll(String name) {
       List<Chart> chartList = cartRepository.findByBuyer_AccountUserName(name);
       Buyer buyer = buyerRepository.findByAccount_UserName(name);
       double totalPrice = 0.0;

        for (Chart chart : chartList){
        totalPrice += ((chart.getProduct().getPrice() * chart.getQuantity())+chart.getShipment().getPrice());
        }

        if (buyer.getWallet() < totalPrice){
            throw new SomethingWrong("Not enough balance");
        }else {
            buyer.setWallet(buyer.getWallet()-totalPrice);
        }
        buyerRepository.save(buyer);

        for (Chart chart : chartList){

            History history = new History();
            history.setDate(LocalDate.now());
            history.setQuantity(chart.getQuantity());
            history.setBuyer(buyer);
            history.setProduct(chart.getProduct());
            history.setShipment(chart.getShipment());

            Seller seller = sellerRepository.findById(chart.getProduct().getId()).orElseThrow(null);
            seller.setWallet(seller.getWallet() + chart.getProduct().getPrice());
            sellerRepository.save(seller);
            historyRepository.save(history);
            cartRepository.deleteAll();
        }

    }
}
