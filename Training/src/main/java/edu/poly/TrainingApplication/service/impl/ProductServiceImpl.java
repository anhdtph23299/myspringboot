package edu.poly.TrainingApplication.service.impl;

import edu.poly.TrainingApplication.custommodel.ProductCustom;
import edu.poly.TrainingApplication.service.ProductService;
import edu.poly.TrainingApplication.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.poly.TrainingApplication.repository.ProductRepository;

import java.util.List;
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepository productRepository;
    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(Long id) {
        return productRepository.getProductByID(id);
    }

    @Override
    public Product insertOrUpdateProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void deleteProduct(Product product) {
        productRepository.delete(product);
    }



}
