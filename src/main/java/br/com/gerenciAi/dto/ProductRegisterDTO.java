package br.com.gerenciAi.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record ProductRegisterDTO(
        @NotBlank(message = "O nome é obrigatório.")
        String name,
        @NotBlank
        String description,
        @NotBlank(message = "A categoria é obrigatória.")
        String category,
        LocalDateTime createdAt,
        @NotNull(message = "O preço é obrigatório.")
        Double price) {
}
