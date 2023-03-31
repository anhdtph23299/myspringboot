package edu.poly.TrainingApplication.controller;

import edu.poly.TrainingApplication.entity.SubCategory;
import edu.poly.TrainingApplication.service.SubcategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/subcategory/")
public class SubcategoryController {
    @Autowired
    SubcategoryService subcategoryService;
    @GetMapping("hien-thi")
    public List<SubCategory> getAll(){
        return subcategoryService.getALl();
    }
}
