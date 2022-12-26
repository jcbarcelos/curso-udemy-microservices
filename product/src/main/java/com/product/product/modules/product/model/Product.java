package com.product.product.modules.product.model;


import com.product.product.config.exception.EntityWithUUID;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Table(name = "Product")
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Product  extends EntityWithUUID {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  @Column(name = "id", nullable = false)
  private Long id;

  @Column(name = "name", nullable = false)
  private String name;

  @ManyToOne
  @JoinColumn(name = "fk_category", nullable = false)
  private Category category;

  @ManyToOne
  @JoinColumn(name = "fk_supplier", nullable = false)
  private Supplier supplier;

  @Column(name = "quantity_available", nullable = false)
  private Integer quantity_available;
}
