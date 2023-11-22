package br.com.gerenciAi.models.client;

import br.com.gerenciAi.dto.ClientEditDTO;
import br.com.gerenciAi.dto.ClientRegisterDTO;
import br.com.gerenciAi.models.address.Address;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Table(name = "tb_clients", uniqueConstraints = {@UniqueConstraint(columnNames = {"name", "email", "phone", "cpf"})})
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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

    public void update(ClientEditDTO data) {
        if(data.email() != null) this.email = data.email();
        if(data.phone() != null) this.phone = data.email();
        if(data.address() != null) this.address = new Address(data.address());
    }
}
