package br.com.gerenciAi.repositories;

import br.com.gerenciAi.models.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, UUID> {
    void deleteById(Long id);
}
