package in.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.com.entity.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity, Integer>{

}
