package com.kienthong.fashion.controllers.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("admin/nhacungcap")
public class NCCController {
    @GetMapping("/")
    public String index() {
        return "admin/nhacungcap/index";
    }

    @GetMapping("/add-nhacungcap")
    public String add() {
        return "admin/nhacungcap/add";
    }

}
