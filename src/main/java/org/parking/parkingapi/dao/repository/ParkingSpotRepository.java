package org.parking.parkingapi.dao.repository;

import org.parking.parkingapi.dao.model.ParkingSpot;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ParkingSpotRepository extends JpaRepository<ParkingSpot, Long> {

    List<ParkingSpot> findByIsOccupied(boolean isOccupied);

    List<ParkingSpot> findBySpotTypeAndIsOccupied(String spotType, boolean isOccupied);

}
