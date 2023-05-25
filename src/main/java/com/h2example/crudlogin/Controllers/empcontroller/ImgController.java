package com.h2example.crudlogin.Controllers.empcontroller;

import com.h2example.crudlogin.Repositories.emprepository.ImgRepo;
import com.h2example.crudlogin.Entities.entity.MysqlImageEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/img")
public class ImgController {
    @Autowired
    ImgRepo imgRepo;

    @GetMapping
    public @ResponseBody List<MysqlImageEntity> getImgLinks() {
        return imgRepo.findAll();
    }
    @PostMapping
    public String saveLInk(@RequestBody MysqlImageEntity img){
       return imgRepo.save(img)!=null?"Image path saved successfully":"failed";
    }
}
