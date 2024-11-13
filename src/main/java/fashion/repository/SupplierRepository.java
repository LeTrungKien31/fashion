package fashion.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fashion.models.admin.Supplier;

public interface SupplierRepository extends JpaRepository<Supplier, Integer>{

}
