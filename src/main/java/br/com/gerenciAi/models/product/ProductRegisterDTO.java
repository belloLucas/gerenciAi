package br.com.gerenciAi.models.product;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record ProductRegisterDTO(
        String name,
        String category,
        LocalDateTime createdAt,
        BigDecimal price) {
}
