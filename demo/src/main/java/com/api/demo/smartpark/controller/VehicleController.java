package com.api.demo.smartpark.controller;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.*;

import com.api.demo.smartpark.dto.VehicleRequestDTO;
import com.api.demo.smartpark.entity.VehicleEntity;
import com.api.demo.smartpark.service.ParkingService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/vehicles")
@RequiredArgsConstructor
public class VehicleController {

	private final ParkingService service;

	@PostMapping
	public VehicleEntity register(@Valid @RequestBody VehicleRequestDTO request) {

		return service.registerVehicle(request);
	}

	@PostMapping("/{plate}/checkin/{lot}")
	public String checkin(@PathVariable String plate, @PathVariable String lot) {

		return service.checkIn(plate, lot);
	}

	@PostMapping("/{plate}/checkout")
	public String checkout(@PathVariable String plate) {

		return service.checkOut(plate);
	}

}
