package fashion.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fashion.models.admin.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer>{
    
}
