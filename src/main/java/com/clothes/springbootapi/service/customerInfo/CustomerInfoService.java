package com.clothes.springbootapi.service.customerInfo;

import com.clothes.springbootapi.domain.dto.CustomerInfoDTO;
import com.clothes.springbootapi.domain.entity.CustomerInfo;
import com.clothes.springbootapi.service.IGeneralService;

import java.util.List;
import java.util.Optional;

public interface CustomerInfoService extends IGeneralService<CustomerInfo> {
    List<CustomerInfoDTO> findCustomerInfoDTO();

    Optional<CustomerInfoDTO> findCustomerInfoDTOById(Long id);
}
