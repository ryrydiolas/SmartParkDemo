package com.api.demo.smartpark.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.api.demo.smartpark.dto.ParkingLotRequestDTO;
import com.api.demo.smartpark.dto.VehicleRequestDTO;
import com.api.demo.smartpark.entity.ParkingLotEntity;
import com.api.demo.smartpark.entity.VehicleEntity;
import com.api.demo.smartpark.repository.ParkingLotRepository;
import com.api.demo.smartpark.repository.VehicleRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ParkingServiceImpl implements ParkingService {

	private final ParkingLotRepository lotRepo;
	private final VehicleRepository vehicleRepo;

	@Override
	public ParkingLotEntity registerLot(ParkingLotRequestDTO request) {

		if (lotRepo.existsById(request.getLotId())) {
			throw new RuntimeException("Parking lot already exists");
		}

		ParkingLotEntity lot = new ParkingLotEntity();

		lot.setLotId(request.getLotId());
		lot.setLocation(request.getLocation());
		lot.setCapacity(request.getCapacity());
		lot.setOccupiedSpaces(0);

		return lotRepo.save(lot);
	}

	@Override
	public VehicleEntity registerVehicle(VehicleRequestDTO request) {

		if (vehicleRepo.existsById(request.getLicensePlate())) {

			throw new RuntimeException("Vehicle already registered");
		}

		if (!request.getType().equalsIgnoreCase("Car") && !request.getType().equalsIgnoreCase("Motorcycle")
				&& !request.getType().equalsIgnoreCase("Truck")) {

			throw new RuntimeException("Vehicle type must be Car, Motorcycle or Truck");
		}

		VehicleEntity vehicle = new VehicleEntity();

		vehicle.setLicensePlate(request.getLicensePlate());

		vehicle.setOwnerName(request.getOwnerName());

		vehicle.setType(request.getType());

		vehicle.setParkedLotId(null);

		return vehicleRepo.save(vehicle);
	}

	@Transactional
	@Override
	public String checkIn(String plate, String lotId) {

		ParkingLotEntity lot = lotRepo.findById(lotId).orElseThrow(() -> new RuntimeException("Parking lot not found"));

		VehicleEntity vehicle = vehicleRepo.findById(plate)
				.orElseThrow(() -> new RuntimeException("Vehicle not found"));

		if (vehicle.getParkedLotId() != null) {

			throw new RuntimeException("Vehicle already parked");
		}

		if (lot.getOccupiedSpaces() >= lot.getCapacity()) {

			throw new RuntimeException("Parking lot is full");
		}

		vehicle.setParkedLotId(lotId);

		lot.setOccupiedSpaces(lot.getOccupiedSpaces() + 1);

		vehicleRepo.save(vehicle);
		lotRepo.save(lot);

		return "Vehicle checked in successfully";
	}

	@Transactional
	@Override
	public String checkOut(String plate) {

		VehicleEntity vehicle = vehicleRepo.findById(plate)
				.orElseThrow(() -> new RuntimeException("Vehicle not found"));

		if (vehicle.getParkedLotId() == null) {

			throw new RuntimeException("Vehicle is not parked");
		}

		ParkingLotEntity lot = lotRepo.findById(vehicle.getParkedLotId())
				.orElseThrow(() -> new RuntimeException("Parking lot not found"));

		vehicle.setParkedLotId(null);

		lot.setOccupiedSpaces(lot.getOccupiedSpaces() - 1);

		vehicleRepo.save(vehicle);
		lotRepo.save(lot);

		return "Vehicle checked out successfully";
	}

	@Override
	public ParkingLotEntity getLot(String id) {

		return lotRepo.findById(id).orElseThrow(() -> new RuntimeException("Parking lot not found"));
	}

	@Override
	public List<VehicleEntity> getVehicles(String lotId) {

		if (!lotRepo.existsById(lotId)) {

			throw new RuntimeException("Parking lot not found");
		}

		return vehicleRepo.findByParkedLotId(lotId);
	}

}
