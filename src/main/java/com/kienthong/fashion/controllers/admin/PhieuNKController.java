package com.kienthong.fashion.controllers.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("admin/phieunhapkho")
public class PhieuNKController {
    @GetMapping("/")
    public String index() {
        return "admin/phieunhapkho/index";
    }

    @GetMapping("/add-phieunhapkho")
    public String add() {
        return "admin/phieunhapkho/add";
    }

}
