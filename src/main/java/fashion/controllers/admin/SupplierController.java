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

import fashion.models.admin.Supplier;
import fashion.service.SupplierService;


@Controller
@RequestMapping("admin/supplier")
public class SupplierController {
    @Autowired
    private SupplierService supplierService;

    @GetMapping("")
    public String index(Model model) {
        List<Supplier> list = supplierService.getAll();
        model.addAttribute("list", list);
        return "admin/supplier/index";
    }

    
    @GetMapping("/add-supplier")
    public String add(Model model) {
        Supplier supplier = new Supplier();
        model.addAttribute("supplier", supplier);
        return "/admin/supplier/add";
    }
    @PostMapping("/add-supplier")
    public String add(@ModelAttribute("supplier") Supplier supplier){
        if(supplierService.create(supplier)){
            return "redirect:/admin/supplier";
        } else{
            return "/admin/supplier/add";
        }

    }

    public Supplier findById(Integer id){
        return supplierService.findById(id);
    }

    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable("id") Integer id){
        Supplier supplier = supplierService.findById(id);
        model.addAttribute("supplier", supplier);
        return "admin/supplier/edit";
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute("supplier") Supplier supplier){
        if(supplierService.update(supplier)){
            return "redirect:/admin/supplier";
        } else{
            return "/admin/supplier/edit";
        }

    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id){
        supplierService.delete(id);
        return "redirect:/admin/supplier";
    }

}
