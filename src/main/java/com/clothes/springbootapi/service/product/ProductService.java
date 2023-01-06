package com.clothes.springbootapi.service.product;

import com.clothes.springbootapi.domain.dto.ProductDTO;
import com.clothes.springbootapi.domain.entity.Product;
import com.clothes.springbootapi.service.IGeneralService;

import java.util.List;
import java.util.Optional;

public interface ProductService extends IGeneralService<Product> {
  List<ProductDTO> findAllProductDTO();

  Optional<ProductDTO> findProductById(Long id);
}
