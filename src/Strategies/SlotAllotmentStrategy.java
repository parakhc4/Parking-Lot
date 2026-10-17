package Strategies;

import Models.Enums.Types.VehicleType;
import Models.ParkingSlot;

import java.util.List;

public interface SlotAllotmentStrategy {
    public ParkingSlot findAvailableSlot(List<ParkingSlot> parkingSlots, VehicleType vehicleType);


}
