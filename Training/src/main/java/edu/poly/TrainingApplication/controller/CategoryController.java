package edu.poly.TrainingApplication.controller;

import edu.poly.TrainingApplication.entity.Category;
import edu.poly.TrainingApplication.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/category/")

public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @GetMapping("hien-thi")
    public List<Category> getAll(){
        return categoryService.getAll();
    }
}
