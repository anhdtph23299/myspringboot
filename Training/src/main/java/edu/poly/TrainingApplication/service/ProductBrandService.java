package edu.poly.TrainingApplication.service;

import edu.poly.TrainingApplication.entity.Product;
import edu.poly.TrainingApplication.entity.ProductBrand;
import org.springframework.data.repository.query.Param;

public interface ProductBrandService {
    ProductBrand insertOrUpdate(ProductBrand productBrand);
    void deleteByProductId(Long id,Long idBrand);

    void delete(ProductBrand productBrand);

    void updateProductbrand(Product product,Long idBrand,Long idProduct);
}
