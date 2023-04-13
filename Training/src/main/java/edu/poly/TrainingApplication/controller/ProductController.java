package edu.poly.TrainingApplication.controller;

import edu.poly.TrainingApplication.custommodel.ProductCustom;
import edu.poly.TrainingApplication.entity.Brand;
import edu.poly.TrainingApplication.entity.ProductBrand;
import edu.poly.TrainingApplication.entity.Status;
import edu.poly.TrainingApplication.entity.SubCategory;
import edu.poly.TrainingApplication.service.ProductBrandService;
import edu.poly.TrainingApplication.service.ProductService;
import edu.poly.TrainingApplication.entity.Product;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = {"*"}, maxAge = 4800, allowCredentials = "false")
@RestController
@RequestMapping("/product/")
public class ProductController {
    @Autowired
    ProductService productService;
    @Autowired
    ProductBrandService productBrandService;

    @Autowired
    @GetMapping("hien-thi")
    public List<Product> getAllProduct() {
        return productService.getAll();
    }

    @GetMapping("getProductCustom")
    public List<ProductCustom> getProductCustom(){
        return productService.getProductCustom();
    }


    @GetMapping("{id}")
    public Product getProductById(@PathVariable(name = "id") String id) {
        Long idUrl = Long.parseLong(id);
        return productService.getProductById(idUrl);
    }
    @PostMapping(value = "add", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ProductCustom addProduct(@Valid @RequestBody ProductCustom productCustom, BindingResult bindingResult) {
        if (bindingResult.hasErrors()){
            throw new RuntimeException();
        }
        SubCategory subCategory = new SubCategory();
        subCategory.setId(productCustom.getIdSubCate());
        Status status = new Status();
        status.setId(productCustom.getIdStatus());

        Product product = new Product(null, subCategory, productCustom.getProductName(), productCustom.getColor(), productCustom.getQuantity()
                , productCustom.getSellPrice(), productCustom.getOriginPrice(), productCustom.getDescription(), status);
        Product productInsert = productService.insertOrUpdateProduct(product);
        Brand brand = productCustom.getBrand();
        ProductBrand productBrand = new ProductBrand();
        productBrand.setProduct(product);
        productBrand.setBrand(brand);
        ProductBrand productBrandInsert = productBrandService.insertOrUpdate(productBrand);
        return productCustom;
    }

    @DeleteMapping("delete/{id}&{idBrand}")
    public void deleteProduct(@PathVariable(name = "id") String id, @PathVariable(name = "idBrand") String idBrand) {
        Long idUrd = Long.parseLong(id);
        Long idBrandUrl = Long.parseLong(idBrand);
        productBrandService.deleteByProductId(idUrd, idBrandUrl);
        Product product = productService.getProductById(idUrd);
        productService.deleteProduct(product);
    }

//    @PutMapping(value = "update/{id}/{brand}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = "application/json")
    @PutMapping(value = "update/{id}/{brand}")
    public ProductCustom updateProduct(@Valid @RequestBody ProductCustom productCustom, @PathVariable(name = "id") String id, @PathVariable(name = "brand") String idBrand,BindingResult bindingResult) {
        if (bindingResult.hasErrors()){
            throw new RuntimeException();
        }
        Long idUrd = Long.parseLong(id);
        Long idUrlBrand = Long.parseLong(idBrand);
        SubCategory subCategory = new SubCategory();
        subCategory.setId(productCustom.getIdSubCate());

        Status status = new Status();
        status.setId(productCustom.getIdStatus());

        Product product = new Product(idUrd, subCategory, productCustom.getProductName(), productCustom.getColor(), productCustom.getQuantity()
                , productCustom.getSellPrice(), productCustom.getOriginPrice(), productCustom.getDescription(), status);
        productService.insertOrUpdateProduct(product);
        ProductBrand productBrand = new ProductBrand();
        productBrand.setBrand(productCustom.getBrand());
//        System.out.println(productCustom.getBrand());
        productBrand.setProduct(product);
        productBrandService.deleteByProductId(idUrd, idUrlBrand);
        productBrandService.insertOrUpdate(productBrand);
        return productCustom;
    }


}
