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
import fashion.service.CategoryService;
import fashion.service.ProductService;
import fashion.service.StorageService;
@Controller
@RequestMapping("admin/product")
public class ProductController {

    @Autowired
    private StorageService storageService;
    @Autowired
    private ProductService productService;
    // @Autowired
    // private fashion.service.user.ProductService productService2;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/product")
    public String getAllProducts(Model model) {
        List<Product> products = productService.getAll();
        model.addAttribute("products", products);
        return "/product"; 
    }
    
    // @GetMapping("/search")
    // public String searchProducts(@RequestParam(value = "q", required = false) String keyword, Model model) {
    //     List<Product> products;
        
    //     if (keyword != null && !keyword.isEmpty()) {
    //         products = productService2.searchProductsByName(keyword);
    //     } else {
    //         products = productService2.getAllProducts(); // Trả về toàn bộ sản phẩm nếu không có từ khóa
    //     }

    //     model.addAttribute("products", products);
    //     model.addAttribute("keyword", keyword); // Truyền từ khóa tìm kiếm để hiển thị lại
    //     return "/product/ao"; // Tên của view hiển thị kết quả tìm kiếm
    // }

    @GetMapping("")
    public String index(Model model) {
        List<Product> list = productService.getAll();
        model.addAttribute("list", list);
        return "admin/product/index";
    }

    @GetMapping("/add-sanpham")
    public String add(Model model) {
        Product product = new Product();
        List<Category> category = categoryService.getAll();
        model.addAttribute("category", category);
        model.addAttribute("product", product);
        return "admin/product/add";
    }
    @PostMapping("/add-product")
    public String add(@ModelAttribute("product") Product product, @RequestParam("fileImage") MultipartFile file){

        storageService.store(file);
        String fileName = file.getOriginalFilename();
        product.setImageUrl(fileName);
        if(productService.create(product)){
            return "redirect:/admin/product";
        } else{
            return "/admin/product/add";
        }
    }

    public Product findById(Integer id){
        return productService.findById(id);
    }

    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable("id") Integer id){
        Product product = productService.findById(id);
        List<Category> category = categoryService.getAll();
        model.addAttribute("category", category);
        model.addAttribute("product", product);
        return "/admin/product/edit";
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute("product") Product product, @RequestParam("fileImage") MultipartFile file){

        storageService.store(file);
        String fileName = file.getOriginalFilename();
        product.setImageUrl(fileName);
        if(productService.update(product)){
            return "redirect:/admin/product";
        } else{
            return "/admin/product/edit";
        }
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id){
        productService.delete(id);
        return "redirect:/admin/product";
    }
    
}


    
