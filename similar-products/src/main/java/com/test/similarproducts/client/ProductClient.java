package com.test.similarproducts.client;

import com.test.similarproducts.model.ProductDetail;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import java.util.Collections;
import java.util.List;

@Component
@RequiredArgsConstructor
public class ProductClient {

    private final WebClient webClient = WebClient.builder()
            .baseUrl("http://localhost:3001")
            .build();

    public List<String> getSimilarProductIds(String productId) {
        try {
            return webClient.get()
                    .uri("/product/{id}/similarids", productId)
                    .retrieve()
                    .bodyToMono(new ParameterizedTypeReference<List<String>>() {})
                    .block();
        } catch (WebClientResponseException.NotFound e) {
            return Collections.emptyList();
        }
    }

    public ProductDetail getProductDetail(String productId) {
        try {
            return webClient.get()
                    .uri("/product/{id}", productId)
                    .retrieve()
                    .bodyToMono(ProductDetail.class)
                    .block();
        } catch (WebClientResponseException.NotFound e) {
            return null;
        }
    }
}
