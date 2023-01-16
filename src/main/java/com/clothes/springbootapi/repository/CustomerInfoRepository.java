package com.clothes.springbootapi.repository;

import com.clothes.springbootapi.domain.dto.CustomerInfoDTO;
import com.clothes.springbootapi.domain.dto.ProductImageDTO;
import com.clothes.springbootapi.domain.entity.CustomerInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerInfoRepository extends JpaRepository<CustomerInfo, Long> {
    @Query("SELECT NEW com.clothes.springbootapi.domain.dto.CustomerInfoDTO (" +
                    "c.id" +
                    ", c.user" +
                    ", c.fullName" +
                    ", c.phone" +
                    ", c.debt" +
                    ", c.locationRegion" +
                    ") " +
                    "FROM CustomerInfo c " +
                    "WHERE c.deleted = false "
            )
    List<CustomerInfoDTO> findCustomerInfoDTO();

    @Query("SELECT NEW com.clothes.springbootapi.domain.dto.CustomerInfoDTO (" +
            "c.id" +
            ", c.user" +
            ", c.fullName" +
            ", c.phone" +
            ", c.debt" +
            ", c.locationRegion" +
            ") " +
            "FROM CustomerInfo c " +
            "WHERE c.deleted = false " +
            "And c.id = ?1 "
    )
    Optional<CustomerInfoDTO> findCustomerInfoDTOById(Long id);
}
