package br.com.gerenciAi.repositories;

import br.com.gerenciAi.models.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ClientRepository extends JpaRepository<User, UUID> {
    User getReferenceById(Long id);

    void deleteById(Long id);
}
