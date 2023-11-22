package br.com.gerenciAi.controllers;

import br.com.gerenciAi.models.product.Product;
import br.com.gerenciAi.dto.ProductEditDTO;
import br.com.gerenciAi.dto.ProductRegisterDTO;
import br.com.gerenciAi.repositories.ProductRepository;
import br.com.gerenciAi.services.ProductService;
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
    private ProductService productService;

    @PostMapping
    @Transactional
    public ResponseEntity create(@RequestBody @Valid ProductRegisterDTO data, UriComponentsBuilder uriBuilder) {
        return productService.create(data, uriBuilder);
    }

    @PatchMapping("/{id}")
    @Transactional
    public ResponseEntity edit(@RequestBody @Valid ProductEditDTO data, @PathVariable Long id) {
        return productService.edit(data, id);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity remove(@PathVariable Long id) {
        return productService.remove(id);
    }

    @GetMapping
    public List<Product> listAllProducts() {
        return productService.listAllProducts();
    }

    @GetMapping("/{id}")
    public Product listProductById(@PathVariable Long id) {
        return productService.listProductById(id);
    }
}
