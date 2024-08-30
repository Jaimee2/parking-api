package org.parking.parkingapi.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.parking.parkingapi.dao.model.ParkingLevel;
import org.parking.parkingapi.dao.model.ParkingSpot;
import org.parking.parkingapi.service.ParkingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/api/parking")
@AllArgsConstructor
public class ParkingController {

    private ParkingService parkingService;

    @GetMapping("/levels")
    public ResponseEntity<List<ParkingLevel>> getAllParkingLevels() {
        List<ParkingLevel> levels = parkingService.getAllParkingLevels();
        return ResponseEntity.ok(levels);
    }

    @GetMapping("/levels/{id}")
    public ResponseEntity<ParkingLevel> getParkingLevelById(@PathVariable Long id) {
        Optional<ParkingLevel> level = parkingService.getParkingLevelById(id);
        return level.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }


    @GetMapping("/spots/available")
    public ResponseEntity<List<ParkingSpot>> getAvailableSpots(@RequestParam String spotType) {
        List<ParkingSpot> availableSpots = parkingService.getAvailableSpots(spotType);
        return ResponseEntity.ok(availableSpots);
    }

    @PostMapping("/spots/{spotId}/occupy")
    public ResponseEntity<ParkingSpot> occupySpot(@PathVariable Long spotId, @RequestParam String vehicleType) {
        ParkingSpot occupiedSpot = parkingService.occupySpot(spotId, vehicleType);
        if (occupiedSpot != null) {
            return ResponseEntity.ok(occupiedSpot);
        } else {
            return ResponseEntity.status(400).body(null);
        }
    }

    // Free a parking spot
    @PostMapping("/spots/{spotId}/free")
    public ResponseEntity<Void> freeSpot(@PathVariable Long spotId) {
        boolean success = parkingService.freeSpot(spotId);
        if (success) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
