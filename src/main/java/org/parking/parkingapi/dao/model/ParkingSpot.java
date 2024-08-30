package org.parking.parkingapi.dao.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "PARKING_SPOT")
public class ParkingSpot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @ToString.Exclude
    @JoinColumn(name = "level_id", nullable = false)
    @JsonBackReference
    private ParkingLevel level;

    @Column(nullable = false)
    private int rowNumber;

    @Column(nullable = false)
    private int spotNumber;

    @Column(nullable = false)
    private String spotType;

    @Column(nullable = false)
    private boolean isOccupied;

    private String vehicleType;
}
