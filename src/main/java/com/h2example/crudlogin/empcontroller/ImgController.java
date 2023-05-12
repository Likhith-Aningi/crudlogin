package com.h2example.crudlogin.empcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.h2example.crudlogin.emprepository.ImgRepo;
import com.h2example.crudlogin.entity.MysqlImageEntity;

@RestController
@RequestMapping("/img")
public class ImgController {
    @Autowired
    ImgRepo imgRepo;

    @GetMapping
    public @ResponseBody Iterable<MysqlImageEntity> getImgLinks() {
        return imgRepo.findAll();
    }
    
}
