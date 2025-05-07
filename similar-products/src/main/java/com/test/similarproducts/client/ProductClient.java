package com.test.similarproducts.client;

import com.test.similarproducts.model.ProductDetail;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ProductClient {

    private final WebClient webClient = WebClient.builder()
            .baseUrl("http://localhost:3001")
            .build();

    public List<String> getSimilarProductIds(String productId) {
        return webClient.get()
                .uri("/product/{id}/similarids", productId)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<String>>() {})
                .block();
    }

    public ProductDetail getProductDetail(String productId) {
        return webClient.get()
                .uri("/product/{id}", productId)
                .retrieve()
                .bodyToMono(ProductDetail.class)
                .block();
    }
}
