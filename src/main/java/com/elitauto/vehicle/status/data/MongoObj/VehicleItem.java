package com.elitauto.vehicle.status.data.MongoObj;

import com.elitauto.vehicle.status.data.enums.Estimator;
import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;

@Data
@ToString
public class VehicleItem {
    @Id
    private String id;
    private Customer customer;
    private String vehicleName;
    private Estimator estimator;
    private LocalDate dropOff;
    private boolean isDroppedOff;
    private boolean rental;
    private LocalDate promisedDate;
    private boolean isPromisedDate;
    private LocalDate repairStartDate;
    private boolean hasRepairStarted;
    private LocalDate repairCompleteDate;
    private boolean hasRepairCompleted;
    private LocalDate vehicleOutDate;
    private boolean isVehicleOut;
    private LocalDate followUpDate;
    private boolean followUpCompleted;
    private int actualNoOfDays;
    private int remainingNoOfDays;
}
