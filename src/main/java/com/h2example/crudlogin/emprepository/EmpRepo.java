package com.h2example.crudlogin.emprepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.h2example.crudlogin.entity.EmpEntity;

public interface EmpRepo extends JpaRepository<EmpEntity, Integer> {

}
