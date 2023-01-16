package com.clothes.springbootapi.controller.api;

import com.clothes.springbootapi.domain.dto.CustomerInfoDTO;
import com.clothes.springbootapi.domain.entity.CustomerInfo;
import com.clothes.springbootapi.service.customerInfo.CustomerInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/customer-info")
public class CustomerInfoController {
    @Autowired
    private CustomerInfoService customerInfoService;

    @GetMapping()
    public ResponseEntity<?> findAllCustomer() {
        List<CustomerInfoDTO> customerInfoDTOList = customerInfoService.findCustomerInfoDTO();
        return new ResponseEntity<>(customerInfoDTOList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findCustomerById(@PathVariable Long id) {
        Optional<CustomerInfoDTO> customerInfoDTO = customerInfoService.findCustomerInfoDTOById(id);
        return new ResponseEntity<>(customerInfoDTO.get(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> doCreateCustomerInfo(@RequestBody CustomerInfoDTO customerInfoDTO){
        customerInfoDTO.setId(0L);
        CustomerInfo customerInfo = customerInfoService.save(customerInfoDTO.toCustomerInfo());
        return new ResponseEntity<>(customerInfo.toCustomerInfoDTO(), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<?> doEditCustomerInfo(@RequestBody CustomerInfoDTO customerInfoDTO){
        CustomerInfo customerInfo = customerInfoService.save(customerInfoDTO.toCustomerInfo());
        return new ResponseEntity<>(customerInfo.toCustomerInfoDTO(), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> doRemoveCustomerInfo(@PathVariable Long id){
        customerInfoService.softDelete(id);
        return new ResponseEntity<>("Remove Success!", HttpStatus.ACCEPTED);
    }
}
