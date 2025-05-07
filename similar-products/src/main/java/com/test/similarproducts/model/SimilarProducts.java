package com.test.similarproducts.model;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SimilarProducts {
  private List<ProductDetail> products;
  // Ready for scalability
}
