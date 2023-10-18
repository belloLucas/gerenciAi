package br.com.gerenciAi.models.product;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record ProductRegisterDTO(
        @NotBlank(message = "O nome é obrigatório.")
        String name,
        @NotBlank(message = "A categoria é obrigatória.")
        String category,
        LocalDateTime createdAt,
        @NotNull(message = "O preço é obrigatório.")
        BigDecimal price) {
}
