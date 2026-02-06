package com.elitauto.vehicle.status.service.impl;

import com.elitauto.vehicle.status.data.MongoObj.VehicleItem;
import com.elitauto.vehicle.status.data.request.EditVehicleRequest;
import com.elitauto.vehicle.status.data.request.VehicleRequest;
import com.elitauto.vehicle.status.repository.VehicleRepository;
import com.elitauto.vehicle.status.utils.VehicleMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class VehicleServiceImpl {

    private final VehicleRepository vehicleRepository;

    public VehicleServiceImpl(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    public VehicleItem addVehicle(VehicleRequest vehicleRequest) {
        return vehicleRepository.save(VehicleMapper.toEntity(vehicleRequest));
    }

    public VehicleItem getVehicle(String id){
        return vehicleRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Vehicle not found"));
    }

    public List<VehicleItem> getAll() {
        return new ArrayList<>(vehicleRepository.findAll());
    }

    public void deleteVehicle(String id) {
        getVehicle(id);
        vehicleRepository.deleteById(id);
    }

    public VehicleItem editVehicle(String id, EditVehicleRequest vehicleRequest){
        VehicleItem existing = getVehicle(id);
        VehicleItem updatedVehicle = VehicleMapper.toEntity(vehicleRequest);
        updatedVehicle.setId(existing.getId());
        return vehicleRepository.save(updatedVehicle);

    }

}
