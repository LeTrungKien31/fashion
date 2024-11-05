package fashion.controllers.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class DonHangController {
    @RequestMapping("admin/donhang")
    public String index() {
        return "admin/donhang/index";
    }

    @RequestMapping("admin/add-donhang")
    public String add() {
        return "admin/donhang/add";
    }

}
