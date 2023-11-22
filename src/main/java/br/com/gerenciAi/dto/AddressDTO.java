package br.com.gerenciAi.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record AddressDTO(
        @NotBlank
        String street,
        @NotBlank
        String neighborhood,
        @NotBlank
        String city,
        @NotBlank
        String state,
        @NotBlank @Pattern(regexp = "\\d{8}")
        String cep,
        @NotBlank
        String houseNumber) {
}
