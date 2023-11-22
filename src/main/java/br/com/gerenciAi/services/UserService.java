package br.com.gerenciAi.services;

import br.com.gerenciAi.dto.UserEditDTO;
import br.com.gerenciAi.dto.UserRegisterDTO;
import br.com.gerenciAi.models.user.User;
import br.com.gerenciAi.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Transactional
    public ResponseEntity createUser(UserRegisterDTO data, UriComponentsBuilder uriBuilder) {
        var user = new User(data);
        userRepository.save(user);

        var uri = uriBuilder.path("/user/{id}").buildAndExpand(user.getId()).toUri();
        return ResponseEntity.created(uri).body(user);
    }

    @Transactional
    public ResponseEntity update(UserEditDTO data, Long id) {
        var user = userRepository.getReferenceById(id);
        user.update(data);
        return ResponseEntity.noContent().build();
    }

    @Transactional
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    public ResponseEntity<List<User>> listAllUsers() {
        var users = userRepository.findAll();
        return ResponseEntity.ok().body(users);
    }

    public ResponseEntity<User> listUserById(Long id) {
        var user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        return ResponseEntity.ok().body(user);
    }
}
