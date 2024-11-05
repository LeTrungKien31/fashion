package fashion.controllers.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PhieuNKController {
    @RequestMapping("admin/phieunhapkho")
    public String index() {
        return "admin/phieunhapkho/index";
    }

    @RequestMapping("admin/add-phieunhapkho")
    public String add() {
        return "admin/phieunhapkho/add";
    }

}
