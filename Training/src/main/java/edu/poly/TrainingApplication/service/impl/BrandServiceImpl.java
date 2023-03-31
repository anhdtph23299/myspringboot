package edu.poly.TrainingApplication.service.impl;

import edu.poly.TrainingApplication.entity.Brand;
import edu.poly.TrainingApplication.repository.BrandRepository;
import edu.poly.TrainingApplication.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BrandServiceImpl implements BrandService {
    @Autowired
    BrandRepository brandRepository;
    @Override
    public List<Brand> getAll() {
        return brandRepository.findAll();
    }

    @Override
    public Brand getById(Long id) {
        return brandRepository.getBrand(id);
    }
}
