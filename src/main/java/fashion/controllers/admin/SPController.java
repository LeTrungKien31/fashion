package fashion.controllers.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class SPController {
    @RequestMapping("admin/sanpham")
    public String index() {
        return "admin/sanpham/index";
    }
    @RequestMapping("admin/add-sanpham")
    public String add() {
        return "admin/sanpham/add";
    }

}



