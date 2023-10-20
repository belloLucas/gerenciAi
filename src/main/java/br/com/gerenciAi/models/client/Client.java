package br.com.gerenciAi.models.client;

import br.com.gerenciAi.models.address.Address;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Client {
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    private String name;
    private String email;
    private String phone;
    private String cpf;

    @Embedded
    private Address address;

    public Client(ClientRegisterDTO data) {
        this.name = data.name();
        this.email = data.email();
        this.phone = data.phone();
        this.cpf = data.cpf();
        this.address = new Address(data.address());
    }
}
