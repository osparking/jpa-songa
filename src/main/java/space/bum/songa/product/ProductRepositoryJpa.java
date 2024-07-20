package space.bum.songa.product;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class ProductRepositoryJpa implements ProductRepositoryInterface {

    @Autowired
    EntityManager entityManager;

    private Map<Integer, Product> db = new HashMap<>();

    public Product findById(int idx) {
        return db.get(idx);
    }

    public void save(Product product) {
        System.out.println(product.getName());
        entityManager.persist(product);
    }

    public List<Product> findAll() {
      TypedQuery<Product> query = entityManager
          .createQuery("SELECT p FROM Product p", Product.class);
      List<Product> products = query.getResultList();

      return products;
    }
}