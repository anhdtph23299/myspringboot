package edu.poly.TrainingApplication.repository;

import edu.poly.TrainingApplication.custommodel.ProductCustom;
import edu.poly.TrainingApplication.entity.Brand;
import edu.poly.TrainingApplication.entity.Category;
import edu.poly.TrainingApplication.entity.Product;
import edu.poly.TrainingApplication.entity.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long> {
    @Query(value = "Select p from Product p where p.id = :id")
    Product getProductByID(@Param("id") Long id);
    @Query(value = "SELECT new edu.poly.TrainingApplication.custommodel.ProductCustom(p.id ,p.subCategory.id, p.productName," +
            " p.color, p.quantity, p.sellPrice, p.originPrice, p.description, p.status.id, pb.brand) " +
            "FROM Product p JOIN p.listProductBrand pb")
    List<ProductCustom> getProductCustom();
    @Query("SELECT p FROM Product p JOIN p.listProductBrand pb WHERE p.productName LIKE %:productName% OR p.sellPrice = :productPrice " +
            "OR pb.brand = :brand OR p.subCategory.category = :category OR p.status = :status")
    List<Product> findAllByItem(@Param("productName") String productName, @Param("productPrice") String productPrice,
                                @Param("brand") Brand brand, @Param("category") Category category, @Param("status") Status status);

}
