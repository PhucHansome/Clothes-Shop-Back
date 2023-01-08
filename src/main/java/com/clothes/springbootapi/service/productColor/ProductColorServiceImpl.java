package com.clothes.springbootapi.service.productColor;

import com.clothes.springbootapi.domain.entity.ProductColor;
import com.clothes.springbootapi.repository.ProductColorRepository;
import io.swagger.annotations.Authorization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductColorServiceImpl implements ProductColorService{
    @Autowired
    ProductColorRepository productColorRepository;

    @Override
    public List<ProductColor> findAll() {
        return productColorRepository.findAll();
    }

    @Override
    public Optional<ProductColor> findById(Long id) {
        return productColorRepository.findById(id);
    }

    @Override
    public ProductColor getById(Long id) {
        return null;
    }

    @Override
    public ProductColor save(ProductColor productColor) {
        return null;
    }

    @Override
    public void remove(Long id) {

    }

    @Override
    public void softDelete(Long id) {

    }
}
