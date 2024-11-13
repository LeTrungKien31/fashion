package fashion.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fashion.models.admin.WarehouseReceipt;
import fashion.repository.ReceiptRepository;
import fashion.service.ReceiptService;

@Service
public class ReceiptServiceImpl implements ReceiptService{
    @Autowired
    private ReceiptRepository repo;

    @Override
    public List<WarehouseReceipt> getAll() {
        return this.repo.findAll();
    }

    @Override
    public Boolean create(WarehouseReceipt warehouseReceipt) {
        try {
            this.repo.save(warehouseReceipt);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Boolean update(WarehouseReceipt warehouseReceipt) {
        try {
            this.repo.save(warehouseReceipt);
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
    public WarehouseReceipt findById(Integer id) {
        return repo.findById(id).get();
    }

}
