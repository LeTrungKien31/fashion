package fashion.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fashion.models.admin.WarehouseReceipt;

public interface ReceiptRepository extends JpaRepository<WarehouseReceipt, Integer>{

}
