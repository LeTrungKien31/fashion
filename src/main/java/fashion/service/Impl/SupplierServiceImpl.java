package fashion.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fashion.models.admin.Supplier;
import fashion.repository.SupplierRepository;
import fashion.service.SupplierService;

@Service
public class SupplierServiceImpl implements SupplierService{

    @Autowired
    private SupplierRepository repo;

    @Override
    public List<Supplier> getAll() {
        return this.repo.findAll();
    }

    @Override
    public Boolean create(Supplier supplier) {
        try {
            this.repo.save(supplier);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Boolean update(Supplier supplier) {
        try {
            this.repo.save(supplier);
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
    public Supplier findById(Integer id) {
        return repo.findById(id).get();
    }


}
