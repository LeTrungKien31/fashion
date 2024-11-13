package fashion.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fashion.models.admin.Category;
import fashion.repository.CategoryRepository;
import fashion.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{

    @Autowired
    private CategoryRepository repo;

    @Override
    public List<Category> getAll() {
        return this.repo.findAll();
    }

    @Override
    public Boolean create(Category category) {
        try {
            this.repo.save(category);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Boolean update(Category category) {
        try {
            this.repo.save(category);
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
    public Category findById(Integer id) {
        return repo.findById(id).get();
    }


}
