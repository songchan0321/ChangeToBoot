package repository;

import dto.Product;
import entities.ProductDetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    Product findByProdNo(Long prodNo);
    List<ProductDetailEntity> findAllByProdNo(Long prodNo);
}
