package com.kienthong.fashion.controllers.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("admin/loaisanpham")
public class LoaiSPController {
    @GetMapping("/")
    public String index() {
        return "admin/loaisanpham/index";
    }
    @GetMapping("/add-loaisanpham")
    public String add() {
        return "admin/loaisanpham/add";
    }

}
