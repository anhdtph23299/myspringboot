package edu.poly.TrainingApplication.repository;

import edu.poly.TrainingApplication.entity.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BrandRepository extends JpaRepository<Brand,Long> {
    @Query(value = "select b from Brand b where b.id = :id")
    Brand getBrand(@Param("id") Long id);
}
