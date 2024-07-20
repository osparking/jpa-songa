package space.bum.songa.product;

import java.util.List;

public interface ProductRepositoryInterface {
  public Product findById(int idx);

  public void save(Product product);

  public List<Product> findAll();
}
