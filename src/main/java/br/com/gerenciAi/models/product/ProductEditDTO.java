package br.com.gerenciAi.models.product;

import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.util.UUID;

public record ProductEditDTO(
        @NotNull
        UUID id,
        String name,
        String category,
        BigDecimal price) {
}
