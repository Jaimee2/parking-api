package org.parking.parkingapi.service;

import org.parking.parkingapi.dao.model.ParkingLevel;
import org.parking.parkingapi.dao.model.ParkingSpot;

import java.util.List;
import java.util.Optional;

public interface ParkingService {

    List<ParkingLevel> getAllParkingLevels();

    Optional<ParkingLevel> getParkingLevelById(Long id);

    List<ParkingSpot> getAvailableSpots(String spotType);

    ParkingSpot occupySpot(Long spotId, String vehicleType);

    boolean freeSpot(Long spotId);
}
