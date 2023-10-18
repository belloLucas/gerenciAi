package br.com.gerenciAi.controllers;

import br.com.gerenciAi.models.product.Product;
import br.com.gerenciAi.models.product.ProductRegisterDTO;
import br.com.gerenciAi.models.product.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity create(@RequestBody ProductRegisterDTO data, UriComponentsBuilder uriBuilder) {
        var product = new Product(data);
        repository.save(product);

        var uri = uriBuilder.path("/product/{id}").buildAndExpand(product.getId()).toUri();

        return ResponseEntity.created(uri).body(product);
    }
}
