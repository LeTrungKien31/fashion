package fashion.service;

import java.util.List;

import fashion.models.admin.WarehouseReceipt;

public interface ReceiptService {
    List<WarehouseReceipt> getAll();
    Boolean create(WarehouseReceipt warehouseReceipt);
    Boolean update(WarehouseReceipt warehouseReceipt);
    void delete(Integer id);
    WarehouseReceipt findById(Integer id);
}
