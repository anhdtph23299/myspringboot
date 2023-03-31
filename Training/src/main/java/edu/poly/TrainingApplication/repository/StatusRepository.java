package edu.poly.TrainingApplication.repository;

import edu.poly.TrainingApplication.entity.Status;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatusRepository extends JpaRepository<Status,Long> {
}
