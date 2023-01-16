package com.clothes.springbootapi.repository;

import com.clothes.springbootapi.domain.entity.LocationRegion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRegionRepository extends JpaRepository<LocationRegion, Long> {
}
