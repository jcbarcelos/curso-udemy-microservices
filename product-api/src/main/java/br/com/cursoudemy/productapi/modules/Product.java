package br.com.cursoudemy.productapi.modules;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.Entity;
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    private Integer id;
    private String name;

    private Category category;

    private Supplier supplier;
}
