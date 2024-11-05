package fashion.controllers.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class ChiTietDhController {
    @RequestMapping("admin/chitietdonhang")
    public String index() {
        return "admin/chitietdonhang/index";
    }
    @RequestMapping("admin/add-chitietdonhang")
    public String add() {
        return "admin/chitietdonhang/add";
    }

}
