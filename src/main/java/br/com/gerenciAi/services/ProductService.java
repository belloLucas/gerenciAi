package br.com.gerenciAi.services;

import br.com.gerenciAi.dto.ProductEditDTO;
import br.com.gerenciAi.dto.ProductRegisterDTO;
import br.com.gerenciAi.models.product.Product;
import br.com.gerenciAi.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Transactional
    public ResponseEntity create(ProductRegisterDTO data, UriComponentsBuilder uriBuilder) {
        var product = new Product(data);
        productRepository.save(product);

        var uri = uriBuilder.path("/product/{id}").buildAndExpand(product.getId()).toUri();
        return ResponseEntity.created(uri).body(product);
    }

    @Transactional
    public ResponseEntity edit(ProductEditDTO data, Long id) {
        var product = productRepository.getReferenceById(id);
        product.updateProduct(data);
        return ResponseEntity.noContent().build();
    }

    @Transactional
    public ResponseEntity delete(Long id) {
        var product = productRepository.findById(id);
        productRepository.deleteById(product.get().getId());
        return ResponseEntity.ok().body(product);
    }

    public List<Product> listAllProducts() {
        return productRepository.findAll();
    }

    public Product listProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));
    }
}
