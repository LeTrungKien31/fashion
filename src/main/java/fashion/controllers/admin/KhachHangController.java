package fashion.controllers.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class KhachHangController {
    @RequestMapping("admin/khachhang")
    public String index() {
        return "admin/khachhang/index";
    }

    @RequestMapping("admin/add-khachhang")
    public String add() {
        return "admin/khachhang/add";
    }

}
