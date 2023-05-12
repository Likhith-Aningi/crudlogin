package com.h2example.crudlogin.empcontroller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.h2example.crudlogin.emprepository.EmpRepo;
import com.h2example.crudlogin.entity.EmpEntity;

@RestController
@RequestMapping("/emp")
public class EmpController {
    @Autowired
    EmpRepo empRepo;

    // save
    @PostMapping("/register")
    public EmpEntity registerEmployee(@RequestBody EmpEntity emp) {
        return empRepo.save(emp);
    }

    // fetchAll
    @GetMapping("/all")
    public List<EmpEntity> fetchAllEmployees() {
        return empRepo.findAll();
    }

    // truncate db
    @GetMapping("/del")
    public void truncateTable() {
        empRepo.deleteAll();
    }

    // update by id
    @PutMapping("/update")
    public EmpEntity updatEmp(@RequestBody EmpEntity emp) {
        return empRepo.save(emp);
    }

    // del emp by id
    @DeleteMapping("/delbyid")
    public String delbyid(@RequestParam int eid) {
        empRepo.deleteById(eid);
        return "emp deleted successfully";
    }

    // get emp by id
    @GetMapping("/findbyid")
    public ResponseEntity<EmpEntity> getbyid(@RequestParam int eid) {
        Optional<EmpEntity> emp = empRepo.findById(eid);
        if (emp.isPresent())
            return new ResponseEntity<>(emp.get(), HttpStatus.OK);
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
