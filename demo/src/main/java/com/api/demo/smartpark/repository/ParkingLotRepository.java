package com.api.demo.smartpark.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.api.demo.smartpark.entity.ParkingLotEntity;


public interface ParkingLotRepository 
extends JpaRepository<ParkingLotEntity,String>{


}