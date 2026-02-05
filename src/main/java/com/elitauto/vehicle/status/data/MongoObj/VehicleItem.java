package com.elitauto.vehicle.status.data.MongoObj;

import com.elitauto.vehicle.status.data.enums.Estimator;
import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Data
@ToString
@Document(collection = "vehicles")
public class VehicleItem {
    @Id
    private String id;
    private Customer customer;
    private String vehicleName;
    private Estimator estimator;
    private LocalDate dropOff;
    private boolean DroppedOffConfirmed;
    private boolean rental;
    private LocalDate promisedDate;
    private boolean PromisedDateConfirmed;
    private LocalDate repairStartDate;
    private boolean hasRepairStarted;
    private LocalDate repairCompleteDate;
    private boolean hasRepairCompleted;
    private LocalDate vehicleOutDate;
    private boolean VehicleOutConfirmed;
    private LocalDate followUpDate;
    private boolean followUpCompleted;
    private int actualNoOfDays;
    private int remainingNoOfDays;
}
