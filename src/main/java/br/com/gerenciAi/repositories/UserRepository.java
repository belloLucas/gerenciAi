package br.com.gerenciAi.repositories;

import br.com.gerenciAi.models.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
