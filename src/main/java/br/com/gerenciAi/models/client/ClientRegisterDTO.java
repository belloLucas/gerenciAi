package br.com.gerenciAi.models.client;

import br.com.gerenciAi.models.address.Address;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record ClientRegisterDTO(
        @NotBlank
        String name,
        @NotBlank
        @Email
        String email,
        @NotBlank
        String phone,
        @NotBlank
        String cpf,
        @NotBlank
        Address address) {
}
