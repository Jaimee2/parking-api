package org.parking.parkingapi;

import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.parking.parkingapi.dao.model.ParkingLevel;
import org.parking.parkingapi.dao.model.ParkingSpot;
import org.parking.parkingapi.dao.repository.ParkingLevelRepository;
import org.parking.parkingapi.dao.repository.ParkingSpotRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@SpringBootApplication
public class ParkingApiApplication {

    private static final Logger log = LoggerFactory.getLogger(ParkingApiApplication.class);
    private ParkingLevelRepository parkingLevelRepository;
    private ParkingSpotRepository parkingSpotRepository;

    public static void main(String[] args) {
        SpringApplication.run(ParkingApiApplication.class, args);
    }

    @PostConstruct
    public void init() {
        log.info("Init generate data");
        // Create Parking Levels
        ParkingLevel level1 = new ParkingLevel(null, 1, new ArrayList<>());
        ParkingLevel level2 = new ParkingLevel(null, 2, new ArrayList<>());
        ParkingLevel level3 = new ParkingLevel(null, 3, new ArrayList<>());

        parkingLevelRepository.save(level1);
        parkingLevelRepository.save(level2);
        parkingLevelRepository.save(level3);

        // Create Parking Spots for Level 1
        List<ParkingSpot> spotsLevel1 = new ArrayList<>();
        spotsLevel1.add(new ParkingSpot(null, level1, 1, 1, "COMPACT", false, null));
        spotsLevel1.add(new ParkingSpot(null, level1, 1, 2, "LARGE", false, null));
        spotsLevel1.add(new ParkingSpot(null, level1, 1, 3, "MOTORCYCLE", false, null));
        spotsLevel1.add(new ParkingSpot(null, level1, 2, 1, "COMPACT", false, null));
        spotsLevel1.add(new ParkingSpot(null, level1, 2, 2, "LARGE", false, null));
        spotsLevel1.add(new ParkingSpot(null, level1, 2, 3, "MOTORCYCLE", false, null));

        parkingSpotRepository.saveAll(spotsLevel1);

        // Create Parking Spots for Level 2
        List<ParkingSpot> spotsLevel2 = new ArrayList<>();
        spotsLevel2.add(new ParkingSpot(null, level2, 1, 1, "COMPACT", false, null));
        spotsLevel2.add(new ParkingSpot(null, level2, 1, 2, "LARGE", false, null));
        spotsLevel2.add(new ParkingSpot(null, level2, 1, 3, "MOTORCYCLE", false, null));
        spotsLevel2.add(new ParkingSpot(null, level2, 2, 1, "COMPACT", false, null));
        spotsLevel2.add(new ParkingSpot(null, level2, 2, 2, "LARGE", false, null));
        spotsLevel2.add(new ParkingSpot(null, level2, 2, 3, "MOTORCYCLE", false, null));

        parkingSpotRepository.saveAll(spotsLevel2);

        // Create Parking Spots for Level 3
        List<ParkingSpot> spotsLevel3 = new ArrayList<>();
        spotsLevel3.add(new ParkingSpot(null, level3, 1, 1, "COMPACT", false, null));
        spotsLevel3.add(new ParkingSpot(null, level3, 1, 2, "LARGE", false, null));
        spotsLevel3.add(new ParkingSpot(null, level3, 1, 3, "MOTORCYCLE", false, null));
        spotsLevel3.add(new ParkingSpot(null, level3, 2, 1, "COMPACT", false, null));
        spotsLevel3.add(new ParkingSpot(null, level3, 2, 2, "LARGE", false, null));
        spotsLevel3.add(new ParkingSpot(null, level3, 2, 3, "MOTORCYCLE", false, null));

        parkingSpotRepository.saveAll(spotsLevel3);

        log.info("Database initialized with parking levels and spots.");
    }
}
