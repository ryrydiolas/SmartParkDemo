package com.api.demo.smartpark.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.demo.smartpark.entity.VehicleEntity;


public interface VehicleRepository
extends JpaRepository<VehicleEntity,String>{


List<VehicleEntity> findByParkedLotId(String lotId);


}