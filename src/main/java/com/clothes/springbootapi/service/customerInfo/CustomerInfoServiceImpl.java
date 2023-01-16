package com.clothes.springbootapi.service.customerInfo;

import com.clothes.springbootapi.domain.dto.CustomerInfoDTO;
import com.clothes.springbootapi.domain.entity.CustomerInfo;
import com.clothes.springbootapi.repository.CustomerInfoRepository;
import com.clothes.springbootapi.repository.LocationRegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CustomerInfoServiceImpl implements CustomerInfoService{
    @Autowired
    private CustomerInfoRepository customerInfoRepository;

    @Autowired
    private LocationRegionRepository locationRegionRepository;


    @Override
    public List<CustomerInfo> findAll() {
        return null;
    }

    @Override
    public Optional<CustomerInfo> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public CustomerInfo getById(Long id) {
        return null;
    }

    @Override
    public CustomerInfo save(CustomerInfo customerInfo) {
        customerInfo.getLocationRegion().setId(0L);
        locationRegionRepository.save(customerInfo.getLocationRegion());
        return customerInfoRepository.save(customerInfo);
    }

    @Override
    public void remove(Long id) {

    }

    @Override
    public void softDelete(Long id) {
        Optional<CustomerInfo> customerInfo = customerInfoRepository.findById(id);
        customerInfo.get().setDeleted(true);
        customerInfoRepository.save(customerInfo.get());
    }

    @Override
    public List<CustomerInfoDTO> findCustomerInfoDTO() {
        return customerInfoRepository.findCustomerInfoDTO();
    }

    @Override
    public Optional<CustomerInfoDTO> findCustomerInfoDTOById(Long id) {
        return customerInfoRepository.findCustomerInfoDTOById(id);
    }
}
