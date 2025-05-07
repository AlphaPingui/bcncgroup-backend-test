package com.test.similarproducts.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.test.similarproducts.model.ProductDetail;
import com.test.similarproducts.service.SimilarProductService;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(SimilarProductController.class)
class SimilarProductControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private SimilarProductService similarProductService;

  @Test
  void shouldReturnSimilarProducts() throws Exception {
    List<ProductDetail> mockProducts =
        List.of(
            new ProductDetail("2", "Product 2", 10.0, true),
            new ProductDetail("3", "Product 3", 20.0, false));

    when(similarProductService.getSimilarProducts("1")).thenReturn(mockProducts);

    mockMvc
        .perform(get("/product/1/similar"))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$.length()").value(2))
        .andExpect(jsonPath("$[0].id").value("2"))
        .andExpect(jsonPath("$[1].id").value("3"));
  }

  @Test
  void shouldReturnNotFoundWhenEmptyList() throws Exception {
    when(similarProductService.getSimilarProducts("1")).thenReturn(List.of());

    mockMvc.perform(get("/product/1/similar")).andExpect(status().isNotFound());
  }
}
