package fashion.models.admin;

import java.time.Instant;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

@Entity
public class ReceiptDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int quantity;
    private double price;
    private Instant createdAt;
    private String createdBy;
    private Instant updatedAt;
    private String updatedBy;

    @ManyToOne
    @JoinColumn(name = "warehouseReceiptId", referencedColumnName = "id")
    private WarehouseReceipt warehouseReceipt;

    @ManyToOne 
    @JoinColumn(name ="productId", referencedColumnName = "id")
    private Product product;
    public ReceiptDetails(){

    }
    @PrePersist
    protected void onCreate() {
        createdAt = Instant.now();
    }

    // Cập nhật ngày hiện tại khi sửa bản ghi
    @PreUpdate
    protected void onUpdate() {
        updatedAt = Instant.now();
    }
    public ReceiptDetails(int id, int quantity, double price, Instant createdAt, String createdBy, Instant updatedAt,
            String updatedBy, WarehouseReceipt warehouseReceipt, Product product) {
        this.id = id;
        this.quantity = quantity;
        this.price = price;
        this.createdAt = createdAt;
        this.createdBy = createdBy;
        this.updatedAt = updatedAt;
        this.updatedBy = updatedBy;
        this.warehouseReceipt = warehouseReceipt;
        this.product = product;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public Instant getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }
    public String getCreatedBy() {
        return createdBy;
    }
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }
    public Instant getUpdatedAt() {
        return updatedAt;
    }
    public void setUpdatedAt(Instant updatedAt) {
        this.updatedAt = updatedAt;
    }
    public String getUpdatedBy() {
        return updatedBy;
    }
    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }
    public WarehouseReceipt getWarehouseReceipt() {
        return warehouseReceipt;
    }
    public void setWarehouseReceipt(WarehouseReceipt warehouseReceipt) {
        this.warehouseReceipt = warehouseReceipt;
    }
    public Product getProduct() {
        return product;
    }
    public void setProduct(Product product) {
        this.product = product;
    }
    
}
