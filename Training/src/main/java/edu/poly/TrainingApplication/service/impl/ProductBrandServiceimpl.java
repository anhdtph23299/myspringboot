package edu.poly.TrainingApplication.service.impl;

import edu.poly.TrainingApplication.entity.Product;
import edu.poly.TrainingApplication.entity.ProductBrand;
import edu.poly.TrainingApplication.repository.ProductBrandRepository;
import edu.poly.TrainingApplication.service.ProductBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class ProductBrandServiceimpl implements ProductBrandService {
    @Autowired
    ProductBrandRepository productBrandRepo;
    @Override
    public ProductBrand insertOrUpdate(ProductBrand productBrand) {
        return productBrandRepo.save(productBrand);
    }

    @Override
    public void deleteByProductId(Long id,Long idBrand) {
        productBrandRepo.deleteByProductId(id,idBrand);
    }

    @Override
    public void delete(ProductBrand productBrand) {
        productBrandRepo.deleteProductBrandByProductAndBrand(productBrand.getProduct(),productBrand.getBrand());
    }

    @Override
    public void updateProductbrand(Product product, Long idBrand, Long idProduct) {
        productBrandRepo.updateProductBrand(product,idBrand,idProduct);
    }


}
