package com.clothes.springbootapi.domain.dto;

import com.clothes.springbootapi.domain.entity.CustomerInfo;
import com.clothes.springbootapi.domain.entity.LocationRegion;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.OneToOne;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Accessors(chain = true)
public class LocationRegionDTO {
    private Long id;

    private String provinceId;

    private String provinceName;

    private String districtId;

    private String districtName;

    private String address;

    private CustomerInfoDTO customerInfo;

    public LocationRegion toLocationRegion(){
        return new LocationRegion()
                .setId(id)
                .setProvinceId(provinceId)
                .setDistrictId(districtId)
                .setDistrictName(districtName)
                .setProvinceName(provinceName)
                .setAddress(address)
                .setCustomerInfo(customerInfo.toCustomerInfo());
    }
}
