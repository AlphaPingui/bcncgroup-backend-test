package com.test.similarproducts.service;

import com.test.similarproducts.client.ProductClient;
import com.test.similarproducts.model.ProductDetail;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SimilarProductService {

  private final ProductClient productClient;

  public List<ProductDetail> getSimilarProducts(String productId) {
    List<String> similarIds = productClient.getSimilarProductIds(productId);

    return similarIds.stream()
        .map(productClient::getProductDetail)
        .filter(Objects::nonNull)
        .collect(Collectors.toList());
  }
}
