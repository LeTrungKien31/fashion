package com.kienthong.fashion.controllers.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("/admin/sanpham")
public class SPController {
    @GetMapping("/")
    public String index() {
        return "admin/sanpham/index";
    }
    @GetMapping("/add-sanpham")
    public String add() {
        return "admin/sanpham/add";
    }

}



