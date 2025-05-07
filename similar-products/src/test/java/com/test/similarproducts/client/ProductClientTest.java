package com.test.similarproducts.client;

import static org.junit.jupiter.api.Assertions.*;

import com.test.similarproducts.model.ProductDetail;
import java.util.List;
import org.junit.jupiter.api.Test;

class ProductClientIntegrationTest {

  private final ProductClient productClient = new ProductClient();

  @Test
  void getSimilarProductIdsReturnsList() {
    List<String> result = productClient.getSimilarProductIds("1");

    assertNotNull(result);
    assertFalse(result.isEmpty());
  }

  @Test
  void getProductDetailReturnsProduct() {
    ProductDetail result = productClient.getProductDetail("2");

    assertNotNull(result);
    assertEquals("2", result.getId());
  }
}
