package br.com.gerenciAi.repositories;

import br.com.gerenciAi.models.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
