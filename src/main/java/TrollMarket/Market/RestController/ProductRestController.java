//package TrollMarket.Market.RestController;
//
//import TrollMarket.Market.Dto.ProductDto;
//import TrollMarket.Market.Dto.ProductDtoshow;
//import TrollMarket.Market.Entity.Product;
//import TrollMarket.Market.Service.Product.ProductService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import javax.validation.Valid;
//import java.util.List;
//
//@RestController
//@RequestMapping("api/products")
//public class ProductRestController {
//
//    @Autowired
//    ProductService productService;
//
//    @PostMapping
//    public ResponseEntity<String> addProduct(@RequestBody ProductDto productDto){
//        productService.saveProduct(productDto);
//        return new ResponseEntity<>("Data Berhasi di input", HttpStatus.OK);
//    }
//
//    @GetMapping
//    public ResponseEntity<List<ProductDtoshow>>showAllProduct(){
//        List<ProductDtoshow> productDtoshows = productService.showProduct();
//        return new ResponseEntity<>(productDtoshows,HttpStatus.OK);
//    }
//
//    @PutMapping
//    public ResponseEntity<String> updatProduct(@RequestBody ProductDto productDto){
//        productService.saveProduct(productDto);
//        return new ResponseEntity<>("Data Berhasi di di update", HttpStatus.OK);
//    }
//
//
//    @GetMapping({"/{id}"})
//    public ResponseEntity<Product>findById(@Valid @PathVariable("id")Integer id){
//        Product product = productService.findByid(id);
//        return new ResponseEntity<>(product, HttpStatus.OK);
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<String>deleteById(@PathVariable("id")Integer id){
//        productService.deleteById(id);
//        return new ResponseEntity<>("data berhasil di hapus",HttpStatus.OK);
//    }
//
//
//
//}
