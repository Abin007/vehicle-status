package com.elitauto.vehicle.status.controller;

import com.elitauto.vehicle.status.data.MongoObj.VehicleItem;
import com.elitauto.vehicle.status.data.request.EditVehicleRequest;
import com.elitauto.vehicle.status.data.request.VehicleRequest;
import com.elitauto.vehicle.status.service.impl.VehicleServiceImpl;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/vehicles")
public class VehicleController {
    private final VehicleServiceImpl vehicleService;

    public VehicleController(VehicleServiceImpl vehicleService){
        this.vehicleService = vehicleService;
    }

    @PostMapping("/add")
    public VehicleItem addVehicle(@Valid @RequestBody VehicleRequest vehicleRequest){
        return vehicleService.addVehicle(vehicleRequest);
    }

    @GetMapping("/getAll")
    public List<VehicleItem> getAllVehicles() {
        return vehicleService.getAll();
    }

    @GetMapping("/{id}")
    public VehicleItem getById(@PathVariable String id) {
        return vehicleService.getVehicle(id);
    }

    @PutMapping("/{id}")
    public VehicleItem editVehicle(@PathVariable String id, @Valid @RequestBody EditVehicleRequest vehicleRequest){
        return vehicleService.editVehicle(id, vehicleRequest);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removeVehicle(@PathVariable String id) {
        vehicleService.deleteVehicle(id);
        return ResponseEntity.noContent().build();
    }



}
