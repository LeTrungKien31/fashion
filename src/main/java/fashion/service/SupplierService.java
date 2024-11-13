package fashion.service;

import java.util.List;

import fashion.models.admin.Supplier;


public interface SupplierService {
    List<Supplier> getAll();
    Boolean create(Supplier supplier);
    Boolean update(Supplier supplier);
    void delete(Integer id);
    Supplier findById(Integer id);
}
