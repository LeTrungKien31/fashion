package com.kienthong.fashion.controllers.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("admin/donhang")
public class DonHangController {
    @GetMapping("/")
    public String index() {
        return "admin/donhang/index";
    }

    @GetMapping("/add-donhang")
    public String add() {
        return "admin/donhang/add";
    }

}
