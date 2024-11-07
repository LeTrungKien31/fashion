package fashion.models.admin;

import java.time.Instant;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String supplierName;
    private String address;
    private String phoneNumber;
    private String email;
    private Instant createdAt;
    private String createdBy;
    private Instant updatedAt;
    private String updatedBy;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "supplier", cascade = CascadeType.ALL)
    private Set<WarehouseReceipt> warehouseReceipt;

    public Supplier(){

    }

    public Supplier(int id, String supplierName, String address, String phoneNumber, String email, Instant createdAt,
            String createdBy, Instant updatedAt, String updatedBy, Set<WarehouseReceipt> warehouseReceipt) {
        this.id = id;
        this.supplierName = supplierName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.createdAt = createdAt;
        this.createdBy = createdBy;
        this.updatedAt = updatedAt;
        this.updatedBy = updatedBy;
        this.warehouseReceipt = warehouseReceipt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public Set<WarehouseReceipt> getWarehouseReceipt() {
        return warehouseReceipt;
    }

    public void setWarehouseReceipt(Set<WarehouseReceipt> warehouseReceipt) {
        this.warehouseReceipt = warehouseReceipt;
    }
    
    
}
