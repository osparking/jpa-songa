package space.bum.songa.product;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
  List<Product> findByNameContaining(String name);
}
