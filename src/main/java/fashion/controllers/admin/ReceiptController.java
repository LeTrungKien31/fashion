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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import fashion.models.admin.Category;
import fashion.models.admin.Product;
import fashion.models.admin.Supplier;
import fashion.models.admin.WarehouseReceipt;
import fashion.service.ReceiptService;
import fashion.service.SupplierService;

@Controller
@RequestMapping("admin/receipt")
public class ReceiptController {
    @Autowired
    private SupplierService supplierService;
    @Autowired
    private ReceiptService receiptService;
    @GetMapping("")
    public String index(Model model) {
        List<WarehouseReceipt> list = receiptService.getAll();
        model.addAttribute("list", list);
        return "admin/receipt/index";
    }

    @GetMapping("/add")
    public String add(Model model) {
        WarehouseReceipt receipt = new WarehouseReceipt();
        List<Supplier> suppliers = supplierService.getAll();
        model.addAttribute("receipt", receipt);
        model.addAttribute("suppliers", suppliers);
        return "/admin/receipt/add";
    }
    @PostMapping("/add")
    public String add(@ModelAttribute("receipt") WarehouseReceipt receipt){
        if(receiptService.create(receipt)){
            return "redirect:/admin/receipt";
        } else{
            return "/admin/receipt/add";
        }
    }

    public WarehouseReceipt findById(Integer id){
        return receiptService.findById(id);
    }

    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable("id") Integer id){
        WarehouseReceipt receipt = receiptService.findById(id);
        List<Supplier> suppliers = supplierService.getAll();
        model.addAttribute("receipt", receipt);
        model.addAttribute("suppliers", suppliers);
        return "/admin/receipt/edit";
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute("receipt") WarehouseReceipt receipt){
        if(receiptService.update(receipt)){
            return "redirect:/admin/receipt";
        } else{
            return "/admin/receipt/edit";
        }
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id){
        receiptService.delete(id);
        return "redirect:/admin/receipt";
    }
}
