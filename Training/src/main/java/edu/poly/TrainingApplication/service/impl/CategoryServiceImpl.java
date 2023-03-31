package edu.poly.TrainingApplication.service.impl;

import edu.poly.TrainingApplication.entity.Category;
import edu.poly.TrainingApplication.repository.CategoryRepository;
import edu.poly.TrainingApplication.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public List<Category> getAll() {
        return categoryRepository.findAll();
    }
}
