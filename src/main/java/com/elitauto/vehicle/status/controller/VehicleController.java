package com.elitauto.vehicle.status.controller;

import com.elitauto.vehicle.status.data.request.DeleteVehicleRequest;
import com.elitauto.vehicle.status.data.request.VehicleRequest;
import com.elitauto.vehicle.status.data.response.DeleteResponse;
import com.elitauto.vehicle.status.service.VehicleService;
import jakarta.validation.Valid;
import org.apache.coyote.BadRequestException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/vehicles")
public class VehicleController {
    public VehicleService vehicleService;

    private VehicleController(VehicleService vehicleService){
        this.vehicleService = vehicleService;
    }

    @PostMapping("/add")
    public ResponseEntity<VehicleRequest> addVehicle(@Valid @RequestBody VehicleRequest vehicleRequest){
        VehicleRequest vehicleItem = vehicleService.addVehicle(vehicleRequest);
        return ResponseEntity.ok().body(vehicleItem);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<VehicleRequest>> getAllVehicles() {
        List<VehicleRequest>  vehicleItems = vehicleService.getAll();
        return ResponseEntity.ok().body(vehicleItems);
    }


    @DeleteMapping("/remove")
    public ResponseEntity<VehicleRequest> removeVehicle(@Valid @RequestBody DeleteVehicleRequest deleteVehicleRequest) throws BadRequestException {
        String id = deleteVehicleRequest.getId();
        return ResponseEntity.ok().body(vehicleService.deleteVehicle(id));
    }



}
