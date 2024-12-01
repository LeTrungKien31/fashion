package com.kienthong.fashion.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("")
public class HomeController {
    public  String layout() {
        return "/index";
    }

}
