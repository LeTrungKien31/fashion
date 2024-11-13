package fashion.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fashion.models.admin.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

}
