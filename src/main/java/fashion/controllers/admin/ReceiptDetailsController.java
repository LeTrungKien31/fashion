package fashion.controllers.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import fashion.models.admin.Product;
import fashion.models.admin.ReceiptDetails;
import fashion.models.admin.Supplier;
import fashion.models.admin.WarehouseReceipt;
import fashion.service.ProductService;
import fashion.service.ReceiptDetailsService;
import fashion.service.ReceiptService;

@Controller
@RequestMapping("admin/receiptdetails")
public class ReceiptDetailsController {

    @Autowired
    private ReceiptDetailsService receiptDetailsService;

    @Autowired
    private ProductService productService;

    @Autowired
    private ReceiptService receiptService;

    @GetMapping("")
    public String index(Model model) {
        List<ReceiptDetails> list = receiptDetailsService.getAll();
        model.addAttribute("list", list);
        return "admin/receiptdetails/index";
    }

    @GetMapping("/add")
    public String add(Model model) {
        ReceiptDetails receiptDetail = new ReceiptDetails();
        List<Product> products = productService.getAll();
        List<WarehouseReceipt> receipts = receiptService.getAll();
        model.addAttribute("receiptDetail", receiptDetail);
        model.addAttribute("products", products);
        model.addAttribute("receipts", receipts);
        return "admin/receiptdetails/add";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute("receiptDetail") ReceiptDetails receiptDetail){
        if(receiptDetailsService.create(receiptDetail)){
            return "redirect:/admin/receiptdetails";
        } else{
            return "/admin/receiptdetails/add";
        }
    }

    public ReceiptDetails findById(Integer id){
        return receiptDetailsService.findById(id);
    }

    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable("id") Integer id){
        ReceiptDetails receiptDetail = receiptDetailsService.findById(id);
        List<Product> products = productService.getAll();
        List<WarehouseReceipt> receipts = receiptService.getAll();
        model.addAttribute("receiptDetail", receiptDetail);
        model.addAttribute("products", products);
        model.addAttribute("receipts", receipts);
        return "/admin/receiptdetails/edit";
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute("receiptDetail") ReceiptDetails receiptDetail){
        if(receiptDetailsService.update(receiptDetail)){
            return "redirect:/admin/receiptdetails";
        } else{
            return "/admin/receiptdetails/edit";
        }
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id){
        receiptDetailsService.delete(id);
        return "redirect:/admin/receiptdetails";
    }

}
