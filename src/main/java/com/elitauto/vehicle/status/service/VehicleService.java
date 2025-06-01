package com.elitauto.vehicle.status.service;

import com.elitauto.vehicle.status.data.request.VehicleRequest;
import com.elitauto.vehicle.status.data.response.DeleteResponse;
import org.apache.coyote.BadRequestException;

import java.util.List;

public interface VehicleService {
    VehicleRequest addVehicle(VehicleRequest vehicleRequest);
    List<VehicleRequest> getAll();
    VehicleRequest deleteVehicle(String id) throws BadRequestException;
}
