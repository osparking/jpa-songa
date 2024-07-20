package space.bum.songa.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    // "사용자(화면) 요청을 던지면" 그걸 받아서
    // 요청에 맞는 메소드를 실행 시킵니다.

    // 그 안에서, 그에 맞는 로직을 수행할 수 있도록 서비스한테 시킬거에요.

    @Autowired
    private ProductService productService;

//    @GetMapping("/connectdb")
//    public void makeConnection() {
//        productService.makeConnection();
//    }

    // 전체 상품 조회
    @GetMapping("/products")
    public List<Product> findProducts() {
        return productService.findProducts(); // JSON array
    }

    // 개별 상품 조회
    @GetMapping("/products/{id}")
    public Product findProduct(@PathVariable("id") int id) {
        System.out.println(id);
        Product result = null;
        try {
          result = productService.findProduct(id);
        } catch (ProductNotFoundException e) { 
          System.out.println(e.getMessage());
        }
          
        return result;
    }

    // 상품 등록
    // @RequestMapping(value = "/products", method= RequestMethod.POST)
    @PostMapping("/products")
    public void saveProduct(@RequestBody Product product) {
        // localhost:8080/products?name=_______ => productName
        System.out.println("POST");
       productService.saveProduct(product);
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test() {
        return "TEST";
    }
}
