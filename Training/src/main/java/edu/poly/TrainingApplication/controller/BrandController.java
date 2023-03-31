package edu.poly.TrainingApplication.controller;

import edu.poly.TrainingApplication.entity.Brand;
import edu.poly.TrainingApplication.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/brand/")
public class BrandController {
    @Autowired
    BrandService brandService;

    @GetMapping("hien-thi")
    public List<Brand> getAll(){
        return brandService.getAll();
    }
    @GetMapping("{id}")
    public Brand getById(@PathVariable(name = "id") Long id){
        return brandService.getById(id);
    }
}
