package com.elitauto.vehicle.status.repository;

import com.elitauto.vehicle.status.data.MongoObj.VehicleItem;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface VehicleRepository extends MongoRepository<VehicleItem, String> {}
