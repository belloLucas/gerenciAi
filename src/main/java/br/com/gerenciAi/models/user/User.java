package br.com.gerenciAi.models.user;

import br.com.gerenciAi.dto.UserEditDTO;
import br.com.gerenciAi.dto.UserRegisterDTO;
import br.com.gerenciAi.models.address.Address;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Table(name = "tb_users", uniqueConstraints = {@UniqueConstraint(columnNames = {"name", "email", "phone", "cpf"})})
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String phone;
    private String cpf;

    @Embedded
    private Address address;

    public User(UserRegisterDTO data) {
        this.name = data.name();
        this.email = data.email();
        this.phone = data.phone();
        this.cpf = data.cpf();
        this.address = new Address(data.address());
    }

    public void update(UserEditDTO data) {
        if(data.email() != null) this.email = data.email();
        if(data.phone() != null) this.phone = data.email();
        if(data.address() != null) this.address = new Address(data.address());
    }
}
