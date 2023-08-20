package com.h2example.crudlogin.Repositories.h2emprepository;

import com.h2example.crudlogin.Entities.entity.EmpEntity;
import com.h2example.crudlogin.Entities.h2entity.H2Entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface H2EmpRepo extends JpaRepository<H2Entity, Integer> {
    EmpEntity findByEname(String ename);
    List<EmpEntity> findByEsal(Float esal);
    @Query("SELECT e.ename,e.eid as EE FROM H2Entity e where e.ename like '%im'")//using manual query example
    List<String> findNameLike();
}
