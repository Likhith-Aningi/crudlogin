package com.h2example.crudlogin.Repositories.emprepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.h2example.crudlogin.Entities.entity.MysqlImageEntity;

public interface ImgRepo extends JpaRepository<MysqlImageEntity, Integer> {

}
