package in.com.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.com.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
