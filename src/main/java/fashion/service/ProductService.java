package fashion.service;

import java.util.List;

import org.springframework.stereotype.Service;

import fashion.models.admin.Product;

@Service
public interface ProductService {
    List<Product> getAll();
    Boolean create(Product product);
    Boolean update(Product product);
    void delete(Integer id);
    Product findById(Integer id);
    
}
