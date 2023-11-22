package br.com.gerenciAi.controllers;

import br.com.gerenciAi.models.client.Client;
import br.com.gerenciAi.dto.ClientEditDTO;
import br.com.gerenciAi.dto.ClientRegisterDTO;
import br.com.gerenciAi.repositories.ClientRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/client")
public class ClientController {
    @Autowired
    private ClientRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity create(@RequestBody ClientRegisterDTO data, UriComponentsBuilder uriBuilder) {
        var client = new Client(data);
        repository.save(client);

        var uri = uriBuilder.path("/client/{id}").buildAndExpand(client.getId()).toUri();
        return ResponseEntity.created(uri).body(client);
    }

    @GetMapping
    public List<Client> list() {
        return repository.findAll();
    }

    @PatchMapping("/{id}")
    @Transactional
    public ResponseEntity update(@RequestBody @Valid ClientEditDTO data, @PathVariable UUID id) {
        var client = repository.getReferenceById(id);
        client.update(data);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void delete(@PathVariable UUID id) {
        repository.deleteById(id);
    }
}
