package com.h2example.crudlogin.Controllers.h2controller;

import com.h2example.crudlogin.Entities.entity.EmpEntity;
import com.h2example.crudlogin.Entities.h2entity.H2Entity;
import com.h2example.crudlogin.Repositories.h2emprepository.H2EmpRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/h2emp")
public class H2EmpController {
    @Autowired
    H2EmpRepo empRepo;

    // save
    @PostMapping("/register")
    public H2Entity registerEmployee(@RequestBody H2Entity emp) {
        return empRepo.save(emp);
    }

    // fetchAll
    @GetMapping("/all")
    public List<H2Entity> fetchAllEmployees() {
        return empRepo.findAll();
    }

    // truncate db
    @GetMapping("/del")
    public void truncateTable() {
        empRepo.deleteAll();
    }

    // update by id
    @PutMapping("/update")
    public H2Entity updatEmp(@RequestBody H2Entity emp) {
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
    public ResponseEntity<H2Entity> getbyid(@RequestParam int eid) {
        Optional<H2Entity> emp = empRepo.findById(eid);
        return emp.map(empEntity -> new ResponseEntity<>(empEntity, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    //for jpa hibernare usage...
    @GetMapping("/findbyname")
    public EmpEntity getbyname(@RequestParam String ename) {
        return empRepo.findByEname(ename);
    }
    @GetMapping("/findbysal")
    public List<EmpEntity> getbysal(@RequestParam Float esal) {
        return empRepo.findByEsal(esal);
    }
    @GetMapping("/nameLike")
    public List<String> getNameLike() {
        return empRepo.findNameLike();
    }
}
