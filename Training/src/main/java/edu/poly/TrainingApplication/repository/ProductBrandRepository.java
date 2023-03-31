package edu.poly.TrainingApplication.repository;

import edu.poly.TrainingApplication.entity.Product;
import edu.poly.TrainingApplication.entity.ProductBrand;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductBrandRepository extends JpaRepository<ProductBrand,Long> {
    @Modifying
    @Transactional
    @Query(value = "Delete from ProductBrand p where p.product.id = :id and p.brand.id = :idBrand")
    void deleteByProductId(@Param("id")Long id,@Param("idBrand")Long idBrand);
    @Modifying
    @Transactional
    @Query(value = "update ProductBrand pb set pb.product =:product where pb.product.id =:idProduct and pb.brand.id =:idBrand")
    void updateProductBrand(@Param("product")Product product, @Param("idBrand")Long idBrand, @Param("idProduct")Long idProduct);
}
