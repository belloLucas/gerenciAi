package br.com.gerenciAi.models.product;

import java.math.BigDecimal;

public record ProductEditDTO(
        String name,
        String category,
        BigDecimal price) {
}
