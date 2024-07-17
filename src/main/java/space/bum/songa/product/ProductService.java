package space.bum.songa.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class ProductService {

    @Autowired
//    private SpringDataJPAProductRepository springDataJPAProductRepository;
    private ProductRepository productRepository;

    ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

//    public void makeConnection() {
//        productRepository.makeConnection();
//    }

    public Product findProduct(int id) {
        return productRepository.findProduct(id);
//        return springDataJPAProductRepository.findById(id).get();
    }

    @Transactional
    public void saveProduct(Product product) {
        productRepository.save(product);
//        springDataJPAProductRepository.save(product);
    }

    public List<Product> findProducts() {
        return productRepository.findProducts();
//        return springDataJPAProductRepository.findAll();
    }
}
