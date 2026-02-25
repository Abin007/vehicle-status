package com.elitauto.vehicle.status.service.impl;

import com.elitauto.vehicle.status.data.MongoObj.VehicleItem;
import com.elitauto.vehicle.status.data.request.EditVehicleRequest;
import com.elitauto.vehicle.status.data.request.VehicleRequest;
import com.elitauto.vehicle.status.repository.VehicleRepository;
import com.elitauto.vehicle.status.utils.VehicleMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class VehicleServiceImpl {

    private final VehicleRepository vehicleRepository;

    public VehicleServiceImpl(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    public VehicleItem addVehicle(VehicleRequest vehicleRequest) {
        VehicleItem vehicleItem = VehicleMapper.toEntity(vehicleRequest);
        vehicleItem.setActualNoOfDays(
                calculateActualNoOfDays(vehicleItem.getDropOff(), vehicleItem.getRepairCompleteDate())
        );
        return vehicleRepository.save(vehicleItem);
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
        updatedVehicle.setActualNoOfDays(
                calculateActualNoOfDays(updatedVehicle.getDropOff(), updatedVehicle.getRepairCompleteDate())
        );
        if (updatedVehicle.getVehicleStatus() == null) {
            updatedVehicle.setVehicleStatus(existing.getVehicleStatus());
        }
        return vehicleRepository.save(updatedVehicle);

    }

    private int calculateActualNoOfDays(LocalDate dropOffDate, LocalDate repairCompleteDate) {
        if (dropOffDate == null || repairCompleteDate == null || repairCompleteDate.isBefore(dropOffDate)) {
            return 0;
        }
        int businessDays = 0;
        LocalDate currentDate = dropOffDate;
        while (!currentDate.isAfter(repairCompleteDate)) {
            DayOfWeek dayOfWeek = currentDate.getDayOfWeek();
            if (dayOfWeek != DayOfWeek.SATURDAY && dayOfWeek != DayOfWeek.SUNDAY) {
                businessDays++;
            }
            currentDate = currentDate.plusDays(1);
        }
        return businessDays;
    }

}
