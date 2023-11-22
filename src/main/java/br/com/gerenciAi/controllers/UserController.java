package br.com.gerenciAi.controllers;

import br.com.gerenciAi.models.user.User;
import br.com.gerenciAi.dto.UserEditDTO;
import br.com.gerenciAi.dto.UserRegisterDTO;
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
@RequestMapping("/user")
public class UserController {
    @Autowired
    private ClientRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity create(@RequestBody UserRegisterDTO data, UriComponentsBuilder uriBuilder) {
        var client = new User(data);
        repository.save(client);

        var uri = uriBuilder.path("/user/{id}").buildAndExpand(client.getId()).toUri();
        return ResponseEntity.created(uri).body(client);
    }

    @GetMapping
    public List<User> list() {
        return repository.findAll();
    }

    @PatchMapping("/{id}")
    @Transactional
    public ResponseEntity update(@RequestBody @Valid UserEditDTO data, @PathVariable Long id) {
        var client = repository.getReferenceById(id);
        client.update(data);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
