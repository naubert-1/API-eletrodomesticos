package br.edu.atitus.productservice.repositories;

import br.edu.atitus.productservice.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.Optional;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

    Optional<ProductEntity> findByDescriptionAndBrandAndModelAndCurrencyAndPriceAndStock(
            String description,
            String brand,
            String model,
            String currency,
            Double price,
            Integer stock
    );
}