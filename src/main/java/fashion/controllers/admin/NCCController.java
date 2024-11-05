package fashion.controllers.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class NCCController {
    @RequestMapping("admin/nhacungcap")
    public String index() {
        return "admin/nhacungcap/index";
    }

    @RequestMapping("admin/add-nhacungcap")
    public String add() {
        return "admin/nhacungcap/add";
    }

}
