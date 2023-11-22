package br.com.gerenciAi.models.product;

import br.com.gerenciAi.dto.ProductEditDTO;
import br.com.gerenciAi.dto.ProductRegisterDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity(name = "tb_products")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private String category;

    @CreationTimestamp
    private LocalDateTime createdAt;

    private Double price;

    public Product(ProductRegisterDTO data) {
        this.name = data.name();
        this.description = data.description();
        this.category = data.category();
        this.createdAt = data.createdAt();
        this.price = data.price();
    }

    public void updateProduct(ProductEditDTO data) {
        if(data.name() != null) this.name = data.name();
        if(data.category() != null) this.category = data.category();
        if(data.price() != null) this.price = data.price();
    }
}
