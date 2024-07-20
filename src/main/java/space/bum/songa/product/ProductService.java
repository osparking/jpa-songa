package space.bum.songa.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class ProductService {

  @Autowired
  private ProductRepository productRepository;

  ProductService(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  public Product findProduct(int id) throws ProductNotFoundException {
    String msg = "다음 아이디의 상품이 없습니다 - 아이디: " + id;
    return productRepository.findById(id)
        .orElseThrow(() -> new ProductNotFoundException(msg));
  }

  @Transactional
  public void saveProduct(Product product) {
    productRepository.save(product);
  }

  public List<Product> findProducts() {
    return productRepository.findAll();
  }

  public List<Product> findByNameContaining(String name) {
    return productRepository.findByNameContaining(name);
  }
}
