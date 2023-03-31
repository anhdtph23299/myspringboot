package edu.poly.TrainingApplication.service.impl;

import edu.poly.TrainingApplication.entity.SubCategory;
import edu.poly.TrainingApplication.repository.SubcategoryRepository;
import edu.poly.TrainingApplication.service.SubcategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class SubcategoryServiceImpl implements SubcategoryService {
    @Autowired
    SubcategoryRepository subcategoryRepository;
    @Override
    public List<SubCategory> getALl() {
        return subcategoryRepository.findAll();
    }
}
