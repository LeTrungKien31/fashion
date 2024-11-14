package fashion.service.Impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fashion.models.admin.ReceiptDetails;
import fashion.repository.ReceiptDetailsRepository;
import fashion.service.ReceiptDetailsService;

@Service
public class ReceiptDetailsServiceImpl implements ReceiptDetailsService{
    @Autowired
    private ReceiptDetailsRepository repo;

    @Override
    public List<ReceiptDetails> getAll() {
        return this.repo.findAll();
    }

    @Override
    public Boolean create(ReceiptDetails receiptDetails) {
        try {
            this.repo.save(receiptDetails);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Boolean update(ReceiptDetails receiptDetails) {
        try {
            this.repo.save(receiptDetails);
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
    public ReceiptDetails findById(Integer id) {
        return repo.findById(id).get();
    }
}
