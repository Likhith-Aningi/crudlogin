package com.h2example.crudlogin.Repositories.emprepository;

import com.h2example.crudlogin.Entities.entity.EmpEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface EmpRepo extends JpaRepository<EmpEntity, Integer> {
    EmpEntity findByEname(String ename);
    List<EmpEntity> findByEsal(Float esal);
    @Query("SELECT e.ename,e.eid as EE FROM EmpEntity e where e.ename like '%im'")//using manual query example
    List<String> findNameLike();
}
