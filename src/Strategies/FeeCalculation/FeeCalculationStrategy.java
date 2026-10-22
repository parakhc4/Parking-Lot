package Strategies.FeeCalculation;

import Models.Enums.Types.VehicleType;

import java.util.Date;

public interface FeeCalculationStrategy {
    public double calculateFee(Date entryTime, Date exitTime, VehicleType vehicleType);
}
