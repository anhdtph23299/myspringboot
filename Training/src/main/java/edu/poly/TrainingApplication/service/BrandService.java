package edu.poly.TrainingApplication.service;

import edu.poly.TrainingApplication.entity.Brand;

import java.util.List;

public interface BrandService {
    List<Brand> getAll();
    Brand getById(Long id);
}
