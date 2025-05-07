package com.test.similarproducts.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.test.similarproducts.client.ProductClient;
import com.test.similarproducts.model.ProductDetail;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SimilarProductServiceTest {

  private ProductClient productClient;
  private SimilarProductService similarProductService;

  @BeforeEach
  void setUp() {
    productClient = mock(ProductClient.class);
    similarProductService = new SimilarProductService(productClient);
  }

  @Test
  void getSimilarProducts_returnsFilteredProductList() {
    when(productClient.getSimilarProductIds("1")).thenReturn(List.of("2", "3", "4"));

    when(productClient.getProductDetail("2"))
        .thenReturn(new ProductDetail("2", "Product 2", 10.0, true));
    when(productClient.getProductDetail("3")).thenReturn(null);
    when(productClient.getProductDetail("4"))
        .thenReturn(new ProductDetail("4", "Product 4", 20.0, false));

    List<ProductDetail> result = similarProductService.getSimilarProducts("1");

    assertEquals(2, result.size());
    assertTrue(result.stream().anyMatch(p -> p.getId().equals("2")));
    assertTrue(result.stream().anyMatch(p -> p.getId().equals("4")));
  }
}
