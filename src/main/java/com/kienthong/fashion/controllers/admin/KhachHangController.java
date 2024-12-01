package com.kienthong.fashion.controllers.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("admin/khachhang")
public class KhachHangController {
    @GetMapping("/")
    public String index() {
        return "admin/khachhang/index";
    }

    @GetMapping("/add-khachhang")
    public String add() {
        return "admin/khachhang/add";
    }

}
