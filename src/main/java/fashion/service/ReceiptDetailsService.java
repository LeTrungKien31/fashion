package fashion.service;

import java.util.List;

import fashion.models.admin.ReceiptDetails;

public interface ReceiptDetailsService {
    List<ReceiptDetails> getAll();
    Boolean create(ReceiptDetails receiptDetails);
    Boolean update(ReceiptDetails receiptDetails);
    void delete(Integer id);
    ReceiptDetails findById(Integer id);
}
