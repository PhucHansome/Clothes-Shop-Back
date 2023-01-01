package com.clothes.springbootapi.domain.entity;

import com.clothes.springbootapi.domain.BaseEntity;
import com.clothes.springbootapi.domain.dto.LocationRegionDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "location_region")
@Accessors(chain = true)
public class LocationRegion extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "province_id")
    private String provinceId;

    @Column(name = "province_name")
    private String provinceName;

    @Column(name = "district_id")
    private String districtId;

    @Column(name = "district_name")
    private String districtName;


    private String address;

    @OneToOne(mappedBy = "locationRegion")
    private CustomerInfo customerInfo;

    public LocationRegionDTO toLocationRegionDTO(){
        return new LocationRegionDTO()
                .setId(id)
                .setProvinceId(provinceId)
                .setDistrictId(districtId)
                .setDistrictName(districtName)
                .setProvinceName(provinceName)
                .setAddress(address)
                .setCustomerInfo(customerInfo.toCustomerInfoDTO());
    }
}
