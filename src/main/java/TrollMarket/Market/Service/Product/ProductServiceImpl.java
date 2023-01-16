package TrollMarket.Market.Service.Product;

import TrollMarket.Market.Dto.ProductDto;
import TrollMarket.Market.Dto.ProductDtoshow;
import TrollMarket.Market.Entity.Product;
import TrollMarket.Market.Entity.Seller;
import TrollMarket.Market.ExeptionHandeler.NotAllowed;
import TrollMarket.Market.ExeptionHandeler.SomethingWrong;
import TrollMarket.Market.Repository.ProductRepository;
import TrollMarket.Market.Repository.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    SellerRepository sellerRepository;

    @Override
    public void saveProduct(ProductDto productDto, String username) {
        try{
            Seller seller = sellerRepository.findByAccount_UserName(username);
            Product product = new Product(
                    productDto.getId(),
                    productDto.getProductName(),
                    productDto.getCategory(),
                    productDto.getDescription(),
                    productDto.getPrice(),
                    productDto.getStatus(),
                    seller);
            productRepository.save(product);
        }catch (Exception e){
            throw new SomethingWrong("something Wrong");
        }
    }


    @Override
    public List<ProductDtoshow> findProductByAccount (String userName) {
        return productRepository.findProductByAccount(userName);
    }

    @Override
    public Product findByid(Integer id) {
        return productRepository.findById(id).orElseThrow(()->{
            throw new NotAllowed("There's no Product With ID" + id);
        }) ;
    }

    @Override
    public void deleteById(Integer id, String username) {
        Product product = findByid(id);
        if (product.getSeller().getAccount().getUserName().equals(username)){
            productRepository.deleteById(id);
        }else {
            throw  new SomethingWrong("can't delete this Product");
        }
    }

    @Override
    public ProductDtoshow findProductById(Integer id) {
        try {
            return productRepository.findProductById(id);
        }catch (Exception e){
            throw new SomethingWrong("id " + id + "is not available" );
        }
    }

    @Override
    public List<Product> findByCategoryOrProductNameOrDescription(String keySearch1,String keySearch2, String keySearch3) {
        return productRepository.findByCategoryLikeIgnoreCaseOrProductNameLikeIgnoreCaseOrDescriptionLikeIgnoreCase(keySearch1,keySearch2,keySearch3);
    }

    @Override
    public List<ProductDtoshow> findAllProduct(String name, String category, String description) {
        return productRepository.findAllProduct(name, category, description);
    }

}
