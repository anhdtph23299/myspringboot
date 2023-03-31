package edu.poly.TrainingApplication.repository;

import edu.poly.TrainingApplication.custommodel.ProductCustom;
import edu.poly.TrainingApplication.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long> {
    @Query(value = "Select p from Product p where p.id = :id")
    Product getProductByID(@Param("id") Long id);


//    @Query(value = "SELECT p.id,p.subCategory,p.productName,p.color,p.quantity,p.sellPrice,p.originPrice," +
//            "p.description,p.status,p.listProductBrand from Product p left join ProductBrand pb left join Brand b")
//    List<ProductCustom> getAllProductCustom();
}
