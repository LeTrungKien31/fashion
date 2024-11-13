package fashion.service;

import java.util.List;


import fashion.models.admin.Category;

public interface CategoryService {
    List<Category> getAll();
    Boolean create(Category category);
    Boolean update(Category category);
    void delete(Integer id);
    Category findById(Integer id);
}
