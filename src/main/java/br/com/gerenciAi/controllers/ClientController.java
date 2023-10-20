package br.com.gerenciAi.controllers;

import br.com.gerenciAi.models.client.Client;
import br.com.gerenciAi.models.client.ClientEditDTO;
import br.com.gerenciAi.models.client.ClientRegisterDTO;
import br.com.gerenciAi.models.client.ClientRepository;
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

    @PatchMapping
    @Transactional
    public ResponseEntity update(@RequestBody @Valid ClientEditDTO data) {
        var client = repository.getReferenceById(data.id());
        client.update(data);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void delete(@PathVariable UUID id) {
        repository.deleteById(id);
    }
}
