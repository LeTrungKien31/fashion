package fashion.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import fashion.models.admin.Product;
import fashion.repository.CategoryRepository;
import fashion.repository.ProductRepository;

@Controller
public class HomeController {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

  
    @GetMapping("/index")
    public String index() {
        return "index";
    }

    @GetMapping("/product/ao")
    public String pageAo(Model model) {
        model.addAttribute("categories", categoryRepository.findAll());
        model.addAttribute("products", productRepository.findAll());
        return "product/ao";
    }

    @GetMapping("/product/quan")
    public String pageQuan(Model model) {
        model.addAttribute("categories", categoryRepository.findAll());
        model.addAttribute("products", productRepository.findAll());
        return "product/quan";
    }

    @GetMapping("/product/giaydep")
    public String pageGiaydep(Model model) {
        model.addAttribute("categories", categoryRepository.findAll());
        model.addAttribute("products", productRepository.findAll());
        return "product/giaydep";
    }

    // @GetMapping("/product/details/{id}")
    // public String details(@PathVariable("id") int id, Model model) {
    //     model.addAttribute("categories", categoryRepository.findAll());
    //     Product product = productRepository.findById(id).orElse(null);
    //     model.addAttribute("product", product);
    //     return "product/details";
    // }
    @GetMapping("/product/details/{id}")
    public String details(@PathVariable("id") int id, Model model) {
    model.addAttribute("categories", categoryRepository.findAll());
    
    Product product = productRepository.findById(id).orElse(null);
    if (product == null) {
        return "redirect:/products"; }
    
    model.addAttribute("product", product);
    return "product/details"; 
}
}