package com.kienthong.fashion.controllers.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("admin/chitietnhap")
public class ChiTietNhapController {
    @GetMapping("/")
    public String index() {
        return "admin/chitietnhap/index";
    }

    @GetMapping("/add-chitietnhap")
    public String add() {
        return "admin/chitietnhap/add";
    }

}
