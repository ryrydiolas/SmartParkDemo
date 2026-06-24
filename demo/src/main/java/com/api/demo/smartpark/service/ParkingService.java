package com.api.demo.smartpark.service;


import java.util.List;

import com.api.demo.smartpark.dto.ParkingLotRequestDTO;
import com.api.demo.smartpark.dto.VehicleRequestDTO;
import com.api.demo.smartpark.entity.ParkingLotEntity;
import com.api.demo.smartpark.entity.VehicleEntity;


public interface ParkingService {


ParkingLotEntity registerLot(
ParkingLotRequestDTO request);



VehicleEntity registerVehicle(
VehicleRequestDTO request);



String checkIn(
String plate,
String lotId);



String checkOut(
String plate);



ParkingLotEntity getLot(
String id);



List<VehicleEntity> getVehicles(
String lotId);



}