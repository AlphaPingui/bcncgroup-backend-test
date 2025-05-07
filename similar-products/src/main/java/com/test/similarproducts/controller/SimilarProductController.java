package com.test.similarproducts.controller;

import com.test.similarproducts.model.ProductDetail;
import com.test.similarproducts.service.SimilarProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class SimilarProductController {

    private final SimilarProductService similarProductService;

    @GetMapping("/{productId}/similar")
    public ResponseEntity<List<ProductDetail>> getSimilarProducts(@PathVariable String productId) {
        List<ProductDetail> similarProducts = similarProductService.getSimilarProducts(productId);

        if (similarProducts.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(similarProducts);
    }
}
