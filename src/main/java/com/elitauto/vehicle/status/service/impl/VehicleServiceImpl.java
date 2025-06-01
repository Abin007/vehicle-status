package com.elitauto.vehicle.status.service.impl;

import com.elitauto.vehicle.status.Validator.DateValidator;
import com.elitauto.vehicle.status.Validator.DateValidatorImpl;
import com.elitauto.vehicle.status.data.MongoObj.VehicleItem;
import com.elitauto.vehicle.status.data.request.VehicleRequest;
import com.elitauto.vehicle.status.data.response.DeleteResponse;
import com.elitauto.vehicle.status.repository.VehicleRepository;
import com.elitauto.vehicle.status.service.VehicleService;
import com.elitauto.vehicle.status.utils.StringToDateConvertor;
import com.elitauto.vehicle.status.utils.StringToEstimatorConvertor;
import org.apache.coyote.BadRequestException;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Service
public class VehicleServiceImpl implements VehicleService {

    private VehicleRepository vehicleRepository;

     private VehicleServiceImpl(VehicleRepository vehicleRepository){
         this.vehicleRepository = vehicleRepository;
     }

    @Override
    public VehicleRequest addVehicle(VehicleRequest vehicleRequest) {
        vehicleRepository.save(vehicleRequest);
        return vehicleRequest;
    }

    @Override
    public List<VehicleRequest> getAll(){
         return vehicleRepository.findAll();
    }

    @Override
    public VehicleRequest deleteVehicle(String id) throws BadRequestException {
        Optional<VehicleRequest> vehicleRequest = vehicleRepository.findById(id);
        if (vehicleRequest.isEmpty()) {
            throw new BadRequestException("Id does not exist. Please provide a valid body");
        } else {
            vehicleRepository.deleteById(id);
            return vehicleRequest.get();
        }
    }

}
