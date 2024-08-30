package org.parking.parkingapi.service.impl;

import lombok.AllArgsConstructor;
import org.parking.parkingapi.dao.model.ParkingLevel;
import org.parking.parkingapi.dao.model.ParkingSpot;
import org.parking.parkingapi.dao.repository.ParkingLevelRepository;
import org.parking.parkingapi.dao.repository.ParkingSpotRepository;
import org.parking.parkingapi.service.ParkingService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ParkingServiceImpl implements ParkingService {

    private ParkingLevelRepository parkingLevelRepository;

    private ParkingSpotRepository parkingSpotRepository;

    public List<ParkingLevel> getAllParkingLevels() {
        return parkingLevelRepository.findAll();
    }

    public Optional<ParkingLevel> getParkingLevelById(Long id) {
        return parkingLevelRepository.findById(id);
    }

    public List<ParkingSpot> getAvailableSpots(String spotType) {
        return parkingSpotRepository.findBySpotTypeAndIsOccupied(spotType, false);
    }

    public ParkingSpot occupySpot(Long spotId, String vehicleType) {
        Optional<ParkingSpot> spot = parkingSpotRepository.findById(spotId);
        if (spot.isPresent() && !spot.get().isOccupied()) {
            ParkingSpot parkingSpot = spot.get();
            parkingSpot.setOccupied(true);
            parkingSpot.setVehicleType(vehicleType);
            return parkingSpotRepository.save(parkingSpot);
        }
        return null;
    }

    public boolean freeSpot(Long spotId) {
        Optional<ParkingSpot> spotOptional = parkingSpotRepository.findById(spotId);
        if (spotOptional.isPresent()) {
            ParkingSpot spot = spotOptional.get();
            if (spot.isOccupied()) {
                spot.setOccupied(false);
                spot.setVehicleType(null);
                parkingSpotRepository.save(spot);
                return true;
            }
        }
        return false;
    }

}