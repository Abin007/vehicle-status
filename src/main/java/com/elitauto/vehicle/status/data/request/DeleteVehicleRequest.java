package com.elitauto.vehicle.status.data.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class DeleteVehicleRequest {

    @NotBlank(message = "Id cannot be blank")
    private String id;
}
