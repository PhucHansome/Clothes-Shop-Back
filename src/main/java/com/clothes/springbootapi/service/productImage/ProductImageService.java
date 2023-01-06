package com.clothes.springbootapi.service.productImage;

import com.clothes.springbootapi.domain.dto.ProductImageDTO;
import com.clothes.springbootapi.domain.entity.ProductImage;
import com.clothes.springbootapi.service.IGeneralService;

import java.util.List;

public interface ProductImageService extends IGeneralService<ProductImage> {
    List<ProductImageDTO> findAllImageProduct(Long id);
}
