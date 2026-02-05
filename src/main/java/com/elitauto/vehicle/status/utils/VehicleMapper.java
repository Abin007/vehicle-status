package com.elitauto.vehicle.status.utils;

import com.elitauto.vehicle.status.data.MongoObj.VehicleItem;
import com.elitauto.vehicle.status.data.enums.Estimator;
import com.elitauto.vehicle.status.data.enums.VehicleStatus;
import com.elitauto.vehicle.status.data.request.VehicleRequest;

public final class VehicleMapper {
    private VehicleMapper() {}

    public static VehicleItem toEntity(VehicleRequest request) {
        if (request == null) {
            return null;
        }
        VehicleItem item = new VehicleItem();
        item.setCustomer(request.getCustomer());
        item.setVehicleName(request.getVehicleName());
        if (request.getEstimator() != null) {
            item.setEstimator(Estimator.valueOf(request.getEstimator().toUpperCase()));
        }
        item.setDropOff(request.getDropOff());
        item.setDroppedOffConfirmed(request.isDroppedOffConfirmed());
        item.setRental(request.isRental());
        item.setPromisedDate(request.getPromisedDate());
        item.setPromisedDateConfirmed(request.isPromisedDateConfirmed());
        item.setRepairStartDate(request.getRepairStartDate());
        item.setHasRepairStarted(request.isHasRepairStarted());
        item.setRepairCompleteDate(request.getRepairCompleteDate());
        item.setHasRepairCompleted(request.isHasRepairCompleted());
        item.setVehicleOutDate(request.getVehicleOutDate());
        item.setVehicleOutConfirmed(request.isVehicleOutConfirmed());
        item.setFollowUpDate(request.getFollowUpDate());
        item.setFollowUpCompleted(request.isFollowUpCompleted());
        item.setActualNoOfDays(request.getActualNoOfDays());
        item.setRemainingNoOfDays(request.getRemainingNoOfDays());
        item.setVehicleStatus(VehicleStatus.NOT_STARTED);
        return item;
    }
}
