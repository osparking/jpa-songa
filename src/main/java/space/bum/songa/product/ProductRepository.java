package space.bum.songa.product;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class ProductRepository {

    @Autowired
    EntityManager entityManager;

    private Map<Integer, Product> db = new HashMap<>();
//    private int id = 1;

    // dataSource로 터널 뚫어보기 (=DB와 커넥션 만들기)
//    public void makeConnection() {
//        DataSourceUtils.getConnection(dataSource);
//    }

    public Product findProduct(int idx) {
        return db.get(idx);
    }

    public void save(Product product) {
        System.out.println(product.getName());
//        db.put(id++, product);
        entityManager.persist(product);
    }

    public List<Product> findProducts() {
      TypedQuery<Product> query = entityManager
          .createQuery("SELECT p FROM Product p", Product.class);
      List<Product> products = query.getResultList();

      return products;
    }
}
