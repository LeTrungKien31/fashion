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

import fashion.models.admin.Category;
import fashion.service.CategoryService;

@Controller
@RequestMapping("admin/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("")
    public String index(Model model) {
        List<Category> list = categoryService.getAll();
        model.addAttribute("list", list);
        return "admin/category/index";
    }

    
    @GetMapping("/add-category")
    public String add(Model model) {
        Category category = new Category();
        model.addAttribute("category", category);
        return "admin/category/add";
    }
    @PostMapping("/add-category")
    public String add(@ModelAttribute("category") Category category){
        if(categoryService.create(category)){
            return "redirect:/admin/category";
        } else{
            return "/admin/category/add";
        }

    }

    public Category findById(Integer id){
        return categoryService.findById(id);
    }

    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable("id") Integer id){
        Category category = categoryService.findById(id);
        model.addAttribute("category", category);
        return "admin/category/edit";
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute("category") Category category){
        if(categoryService.create(category)){
            return "redirect:/admin/category";
        } else{
            return "/admin/category/edit";
        }

    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id){
        categoryService.delete(id);
        return "redirect:/admin/category";
    }
}
