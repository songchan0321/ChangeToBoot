package repository;

import dto.ProductDetail;
import entities.ProductEntity;
import entities.ProductDetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductDetailRepository extends JpaRepository<ProductDetail,Long> {

    List<ProductDetail> findAllByProduct_ProdNo(Long prodNo);

}