package space.bum.songa.product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.stereotype.Repository;

@Repository
public class ProductRepository {

    @Autowired
//    EntityManager entityManager;
    DataSource dataSource;

    private Map<Integer, Product> db = new HashMap<>();
    private int id = 1;

    // dataSource로 터널 뚫어보기 (=DB와 커넥션 만들기)
    public void makeConnection() {
        DataSourceUtils.getConnection(dataSource);
    }

    public Product findProduct(int idx) {
        return db.get(idx);
    }

    public void save(Product product) {
        System.out.println(product.getName());
        db.put(id++, product);
//        entityManager.persist(product);
    }

    public List<Product> findProducts() {
        return new ArrayList<>(db.values());
//        TypedQuery<Product> query = entityManager.createQuery("SELECT p FROM Product p", Product.class);
//        List<Product> products = query.getResultList();

//        return products;
    }
}
