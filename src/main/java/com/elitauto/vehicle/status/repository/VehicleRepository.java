package com.elitauto.vehicle.status.repository;

import com.elitauto.vehicle.status.data.request.VehicleRequest;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface VehicleRepository extends MongoRepository<VehicleRequest, String> {
    public List<VehicleRequest> findAll();
}
