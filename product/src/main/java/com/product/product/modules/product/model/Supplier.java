package com.product.product.modules.product.model;
import com.product.product.config.exception.EntityWithUUID;
import com.product.product.modules.product.dto.CategoryRequest;
import com.product.product.modules.product.dto.SupplierRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;
import org.springframework.beans.BeanUtils;

@Data
@Table(name = "Supplier")
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Supplier extends EntityWithUUID {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;


    public static Supplier of(SupplierRequest supplierRequest) {
        var supplier = new Supplier();
        BeanUtils.copyProperties(supplierRequest, supplier);
        return supplier;
    }

}
