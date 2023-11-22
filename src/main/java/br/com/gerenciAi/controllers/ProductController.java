package br.com.gerenciAi.controllers;

import br.com.gerenciAi.models.product.Product;
import br.com.gerenciAi.dto.ProductEditDTO;
import br.com.gerenciAi.dto.ProductRegisterDTO;
import br.com.gerenciAi.repositories.ProductRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity create(@RequestBody @Valid ProductRegisterDTO data, UriComponentsBuilder uriBuilder) {
        var product = new Product(data);
        repository.save(product);

        var uri = uriBuilder.path("/product/{id}").buildAndExpand(product.getId()).toUri();
        return ResponseEntity.created(uri).body(product);
    }

    @PatchMapping("/{id}")
    @Transactional
    public ResponseEntity edit(@RequestBody @Valid ProductEditDTO data, @PathVariable UUID id) {
        var product = repository.getReferenceById(id);
        product.updateProduct(data);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity remove(@PathVariable UUID id) {
        var product = repository.findById(id);
        repository.deleteById(product.get().getId());
        return ResponseEntity.ok().body(product);
    }

    @GetMapping
    public List<Product> list() {
        return repository.findAll();
    }
}
