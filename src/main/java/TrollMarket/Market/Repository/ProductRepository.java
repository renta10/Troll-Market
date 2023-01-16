package TrollMarket.Market.Repository;

import TrollMarket.Market.Dto.ProductDtoshow;
import TrollMarket.Market.Entity.Product;
import TrollMarket.Market.Entity.Seller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Integer> {

    @Query("""
     SELECT new TrollMarket.Market.Dto.ProductDtoshow
    (pro.id, pro.productName,pro.category,pro.price,pro.description,pro.status)
    FROM Product as pro join Seller as sel on sel.id = pro.seller.id 
    join Account as ac on ac.userName = sel.account.userName
    where sel.account.userName = :username
    """)
    List<ProductDtoshow> findProductByAccount(String username);


   @Query("""
    SELECT new TrollMarket.Market.Dto.ProductDtoshow
    (pro.id, pro.productName,pro.category,pro.price,pro.description,pro.status) 
    FROM Product as pro
    where pro.id = :id
    """)
    ProductDtoshow findProductById(Integer id);

   @Query("""
     SELECT new TrollMarket.Market.Dto.ProductDtoshow
    (pro.id, pro.productName,pro.category,pro.price,pro.description,pro.status) 
    FROM Product as pro
    where pro.productName LIKE %:nama% and pro.category like %:category% and pro.description like %:description%
    """)
    List<ProductDtoshow>findAllProduct(@Param("nama")String nama, @Param("category")String category, @Param("description")String description );

    List<Product>findByCategoryLikeIgnoreCaseOrProductNameLikeIgnoreCaseOrDescriptionLikeIgnoreCase(String keySearch1,String keySearch2,String keySearch3);
//   List<ProductDtoshow>findByCategoryOrProductNameOrDescription(String keySearch);
}
