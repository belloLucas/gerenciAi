package br.com.gerenciAi.controllers;

import br.com.gerenciAi.models.client.Client;
import br.com.gerenciAi.models.client.ClientRegisterDTO;
import br.com.gerenciAi.models.client.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

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
}
