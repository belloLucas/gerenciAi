package br.com.gerenciAi.models.client;

import br.com.gerenciAi.models.address.AddressDTO;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record ClientEditDTO(
        String email,
        String phone,
        AddressDTO address
) {
}
