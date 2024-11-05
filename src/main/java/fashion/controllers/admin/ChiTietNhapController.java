package fashion.controllers.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class ChiTietNhapController {
    @RequestMapping("admin/chitietnhap")
    public String index() {
        return "admin/chitietnhap/index";
    }

    @RequestMapping("admin/add-chitietnhap")
    public String add() {
        return "admin/chitietnhap/add";
    }

}
