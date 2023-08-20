package com.h2example.crudlogin.Controllers.empcontroller;

import com.h2example.crudlogin.Entities.entity.EmpEntity;
import com.h2example.crudlogin.Repositories.emprepository.EmpRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
