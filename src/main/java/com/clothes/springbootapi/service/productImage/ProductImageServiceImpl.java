package com.clothes.springbootapi.service.productImage;

import com.clothes.springbootapi.domain.dto.ProductImageDTO;
import com.clothes.springbootapi.domain.entity.ProductImage;
import com.clothes.springbootapi.repository.ProductImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductImageServiceImpl implements ProductImageService {
    @Autowired
    ProductImageRepository productImageRepository;

    @Override
    public List<ProductImage> findAll() {
        return null;
    }

    @Override
    public Optional<ProductImage> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public ProductImage getById(Long id) {
        return null;
    }

    @Override
    public ProductImage save(ProductImage productImage) {
        return productImageRepository.save(productImage);
    }

    @Override
    public void remove(Long id) {
        productImageRepository.deleteById(id);
    }

    @Override
    public void softDelete(Long id) {

    }

    @Override
    public List<ProductImageDTO> findAllImageProduct(Long id) {
        return productImageRepository.findAllImageProduct(id);
    }
}
