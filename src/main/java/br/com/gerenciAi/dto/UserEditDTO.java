package br.com.gerenciAi.dto;

public record UserEditDTO(
        String email,
        String phone,
        AddressDTO address
) {
}
