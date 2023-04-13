package edu.poly.TrainingApplication.service;

import edu.poly.TrainingApplication.custommodel.ProductCustom;
import edu.poly.TrainingApplication.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAll();

    Product getProductById(Long id);

    Product insertOrUpdateProduct(Product product);
    void deleteProduct(Product product);

    List<ProductCustom> getProductCustom();


//    ListInterface

//     ArrayList
//      Stack
}
