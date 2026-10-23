package Strategies.FeeCalculation;

import Models.Enums.Types.VehicleType;

import java.time.Duration;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class FixedFeeCalculationStrategy implements FeeCalculationStrategy{
//    Map<VehicleType,Double> feePerVehicle = new HashMap<VehicleType, Double>();
//
//    private FixedFeeCalculationStrategy(Map<VehicleType,Double> feePerVehicle){
//        this.feePerVehicle.put(VehicleType.BIKE,20.0);
//        this.feePerVehicle.put(VehicleType.CAR,50.0);
//        this.feePerVehicle.put(VehicleType.TRUCK,100.0);
//    }
    public double calculateFee(Date entryTime, Date exitTime, VehicleType vehicleType){
        return Double.valueOf(100);
    }

}

