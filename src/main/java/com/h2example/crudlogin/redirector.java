package com.h2example.crudlogin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class redirector {
    @RequestMapping("/") public String MainRedirect(){
        return "redirect:/test/html";
    }
}
