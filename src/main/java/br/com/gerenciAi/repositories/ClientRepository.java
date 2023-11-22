package br.com.gerenciAi.repositories;

import br.com.gerenciAi.models.client.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ClientRepository extends JpaRepository<Client, UUID> {
}
