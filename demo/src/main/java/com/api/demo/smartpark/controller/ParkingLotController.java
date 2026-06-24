package com.api.demo.smartpark.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.*;

import com.api.demo.smartpark.dto.ParkingLotRequestDTO;
import com.api.demo.smartpark.entity.ParkingLotEntity;
import com.api.demo.smartpark.entity.VehicleEntity;
import com.api.demo.smartpark.service.ParkingService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/lots")
@RequiredArgsConstructor
public class ParkingLotController {

	private final ParkingService service;

	@PostMapping
	public ParkingLotEntity create(@Valid @RequestBody ParkingLotRequestDTO request) {

		return service.registerLot(request);
	}

	@GetMapping("/{id}")
	public ParkingLotEntity get(@PathVariable String id) {

		return service.getLot(id);
	}

	@GetMapping("/{id}/vehicles")
	public List<VehicleEntity> vehicles(@PathVariable String id) {

		return service.getVehicles(id);
	}

}
