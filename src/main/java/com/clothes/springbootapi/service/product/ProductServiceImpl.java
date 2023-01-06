package com.clothes.springbootapi.service.product;

import com.clothes.springbootapi.domain.dto.ProductDTO;
import com.clothes.springbootapi.domain.entity.Product;
import com.clothes.springbootapi.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductServiceImpl implements ProductService{
    @Autowired
    ProductRepository productRepository;

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Product getById(Long id) {
        return null;
    }

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void remove(Long id) {

    }

    @Override
    public void softDelete(Long id) {
        Optional<ProductDTO> productDTO = productRepository.findProductDTOById(id);
        productDTO.get().toProduct().setDeleted(true);
        productRepository.save(productDTO.get().toProduct());
    }

    @Override
    public List<ProductDTO> findAllProductDTO() {
        return productRepository.findAllProductDTO();
    }

    @Override
    public Optional<ProductDTO> findProductById(Long id) {
        return productRepository.findProductDTOById(id);
    }
}
