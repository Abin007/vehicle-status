package com.elitauto.vehicle.status.data.request;

import com.elitauto.vehicle.status.Validator.ValidEnum;
import com.elitauto.vehicle.status.data.MongoObj.Customer;
import com.elitauto.vehicle.status.data.enums.Estimator;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
public class VehicleRequest {
    @Valid
    private Customer customer;
    @NotBlank(message = "Vehicle Name cannot be blank")
    @Size(min = 1, max = 50, message = "Vehicle Name must be between 2 and 50 characters")
    private String vehicleName;
    @NotBlank(message = "Estimator cannot be blank")
    @Valid
    @ValidEnum(enumClass = Estimator.class, message = "Must be one of the values in enum")
    private String estimator;
    @NotNull(message = "Drop off date cannot be blank")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate dropOff;
    private boolean DroppedOffConfirmed;
    private boolean rental;
    @NotNull(message = "Promised date cannot be blank")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate promisedDate;
    private boolean promisedDateConfirmed;
    @NotNull(message = "Repair Start Date cannot be blank")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate repairStartDate;
    private boolean hasRepairStarted;
    @NotNull(message = "Repair Complete Date cannot be blank")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate repairCompleteDate;
    private boolean hasRepairCompleted;
    @NotNull(message = "Vehicle Out Date cannot be blank")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate vehicleOutDate;
    private boolean VehicleOutConfirmed;
    @NotNull(message = "Follow Up cannot be blank")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate followUpDate;
    private boolean followUpCompleted;

}
