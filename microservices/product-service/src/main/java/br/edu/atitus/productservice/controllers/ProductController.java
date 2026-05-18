package br.edu.atitus.productservice.controllers;

import br.edu.atitus.productservice.dtos.ProductDTO;
import java.util.Map;
import br.edu.atitus.productservice.entities.ProductEntity;
import br.edu.atitus.productservice.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("product")
public class ProductController {

    private final ProductRepository repository;

    private String base;
    private Map<String, Double> rates;

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public Map<String, Double> getRates() {
        return rates;
    }

    public void setRates(Map<String, Double> rates) {
        this.rates = rates;
    }

    @Value("${server.port}")
    private String port;

    public ProductController(ProductRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public ResponseEntity<ProductDTO> getProduct(
            @RequestParam Long id,
            @RequestParam String currency
    ) {

        ProductEntity product = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

        ProductDTO dto = new ProductDTO(
                product.getId(),
                product.getDescription(),
                product.getBrand(),
                product.getModel(),
                product.getCurrency(),
                product.getPrice(),
                product.getStock(),
                "Product-service running on Port: " + port,
                null,
                currency
        );

        return ResponseEntity.ok(dto);
    }

}