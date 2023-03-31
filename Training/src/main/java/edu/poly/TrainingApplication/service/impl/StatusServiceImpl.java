package edu.poly.TrainingApplication.service.impl;

import edu.poly.TrainingApplication.entity.Status;
import edu.poly.TrainingApplication.repository.StatusRepository;
import edu.poly.TrainingApplication.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatusServiceImpl implements StatusService {

    @Autowired
    StatusRepository statusRepository;


    @Override
    public List<Status> getAll() {
        return statusRepository.findAll();
    }
}
