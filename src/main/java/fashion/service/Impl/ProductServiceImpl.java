package fashion.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fashion.models.admin.Product;
import fashion.repository.ProductRepository;
import fashion.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository repo;

    @Override
    public List<Product> getAll() {
        return this.repo.findAll();
    }

    @Override
    public Boolean create(Product product) {
        try {
            this.repo.save(product);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Boolean update(Product product) {
        try {
            this.repo.save(product);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public void delete(Integer id) {
        repo.deleteById(id);
    }

    @Override
    public Product findById(Integer id) {
        return repo.findById(id).get();
    }

}
