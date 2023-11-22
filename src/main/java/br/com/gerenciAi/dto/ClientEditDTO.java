package br.com.gerenciAi.dto;

public record ClientEditDTO(
        String email,
        String phone,
        AddressDTO address
) {
}
