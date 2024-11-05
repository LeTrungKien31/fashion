package fashion.controllers.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class LoaiSPController {
    @RequestMapping("admin/loaisanpham")
    public String index() {
        return "admin/loaisanpham/index";
    }
    @RequestMapping("admin/add-loaisanpham")
    public String add() {
        return "admin/loaisanpham/add";
    }

}
