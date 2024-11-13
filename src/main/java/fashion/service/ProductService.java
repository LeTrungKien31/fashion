package fashion.service;

import java.util.List;

import fashion.models.admin.Product;

public interface ProductService {
    List<Product> getAll();
    Boolean create(Product product);
    Boolean update(Product product);
    void delete(Integer id);
    Product findById(Integer id);
}
