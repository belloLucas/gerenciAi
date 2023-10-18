package br.com.gerenciAi.models.product;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity(name = "tb_products")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String name;
    private String category;

    @CreationTimestamp
    private LocalDateTime createdAt;

    private BigDecimal price;

    public Product(ProductRegisterDTO data) {
        this.name = data.name();
        this.category = data.category();
        this.createdAt = data.createdAt();
        this.price = data.price();
    }
}
