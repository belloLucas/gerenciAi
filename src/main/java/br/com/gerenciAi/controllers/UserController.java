package br.com.gerenciAi.controllers;

import br.com.gerenciAi.dto.UserEditDTO;
import br.com.gerenciAi.dto.UserRegisterDTO;
import br.com.gerenciAi.models.user.User;
import br.com.gerenciAi.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity create(@RequestBody UserRegisterDTO data, UriComponentsBuilder uriBuilder) {
        return userService.createUser(data, uriBuilder);
    }

    @GetMapping
    public List<User> listAllUsers() {
        return userService.listAllUsers().getBody();
    }

    @GetMapping("/{id}")
    public User listUserById(@PathVariable Long id) {
        return userService.listUserById(id).getBody();
    }

    @PatchMapping("/{id}")
    public ResponseEntity update(@RequestBody @Valid UserEditDTO data, @PathVariable Long id) {
        return userService.update(data, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        userService.delete(id);
    }
}
