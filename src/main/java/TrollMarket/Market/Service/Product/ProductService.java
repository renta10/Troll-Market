package TrollMarket.Market.Service.Product;

import TrollMarket.Market.Dto.ProductDto;
import TrollMarket.Market.Dto.ProductDtoshow;
import TrollMarket.Market.Entity.Product;

import java.util.List;

public interface ProductService {
    public void saveProduct(ProductDto productDto, String username)throws Exception;
    List<ProductDtoshow> findProductByAccount(String Username);
    Product findByid(Integer id);
    void deleteById(Integer id, String username);
    ProductDtoshow findProductById (Integer id);

    List<Product> findByCategoryOrProductNameOrDescription(String keySearch1,String keySearch2,String keySearch3   );

    List<ProductDtoshow> findAllProduct(String name, String category, String description);
}
