package org.parking.parkingapi.dao.repository;

import org.parking.parkingapi.dao.model.ParkingLevel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParkingLevelRepository extends JpaRepository<ParkingLevel, Long> {
}
