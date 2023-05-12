package com.h2example.crudlogin.emprepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.h2example.crudlogin.entity.MysqlImageEntity;

public interface ImgRepo extends JpaRepository<MysqlImageEntity, Integer> {

}
