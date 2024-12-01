package com.kienthong.fashion.controllers.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("admin/chitietdonhang")
public class ChiTietDhController {
    @GetMapping("/")
    public String index() {
        return "admin/chitietdonhang/index";
    }
    @GetMapping("/add-chitietdonhang")
    public String add() {
        return "admin/chitietdonhang/add";
    }

}
