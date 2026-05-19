package br.edu.atitus.productservice.dtos;

public record ProductDTO(

        Long id,
        String description,
        String brand,
        String model,
        String currency,
        Double price,
        Integer stock,
        String environment,
        Double convertedPrice,
        br.edu.atitus.productservice.clients.CurrencyResponse requestedCurrency
) {
}

