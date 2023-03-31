package edu.poly.TrainingApplication.controller;

import edu.poly.TrainingApplication.entity.Status;
import edu.poly.TrainingApplication.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@CrossOrigin

@RestController
@RequestMapping("/status/")
public class StatusController {
    @Autowired
    StatusService statusService;

    @GetMapping("hien-thi")
    public List<Status> getAll(){
        return statusService.getAll();
    }
}
