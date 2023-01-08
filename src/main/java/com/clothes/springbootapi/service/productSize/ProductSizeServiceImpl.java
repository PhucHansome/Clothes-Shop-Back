package com.clothes.springbootapi.service.productSize;

import com.clothes.springbootapi.domain.entity.ProductSize;
import com.clothes.springbootapi.repository.ProductSizeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductSizeServiceImpl implements ProductSizeService{
    @Autowired
    ProductSizeRepository productSizeRepository;

    @Override
    public List<ProductSize> findAll() {
        return productSizeRepository.findAll();
    }

    @Override
    public Optional<ProductSize> findById(Long id) {
        return productSizeRepository.findById(id);
    }

    @Override
    public ProductSize getById(Long id) {
        return null;
    }

    @Override
    public ProductSize save(ProductSize productSize) {
        return null;
    }

    @Override
    public void remove(Long id) {

    }

    @Override
    public void softDelete(Long id) {

    }
}
