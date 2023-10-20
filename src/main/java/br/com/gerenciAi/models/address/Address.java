package br.com.gerenciAi.models.address;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    private String street;
    private String neighborhood;
    private String city;
    private String state;
    private String cep;
    private String houseNumber;

    public Address(AddressDTO data) {
        this.street = data.street();
        this.neighborhood = data.neighborhood();
        this.city = data.city();
        this.state = data.state();
        this.cep = data.cep();
        this.houseNumber = data.houseNumber();
    }
}
