package Strategies.FeeCalculation;

import Models.Enums.Types.VehicleType;

import java.time.Duration;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class HourlyFeeCalculationStrategy implements FeeCalculationStrategy{
    Map<VehicleType,Double> feePerVehicle = new HashMap<VehicleType, Double>();

    public HourlyFeeCalculationStrategy(){
        this.feePerVehicle.put(VehicleType.BIKE,20.0);
        this.feePerVehicle.put(VehicleType.CAR,50.0);
        this.feePerVehicle.put(VehicleType.TRUCK,100.0);
    }
    public double calculateFee(Date entryTime, Date exitTime, VehicleType vehicleType){

        double hours = Duration.between(entryTime.toInstant(),exitTime.toInstant()).toHours();
        double cost = hours * feePerVehicle.get(vehicleType);
        return cost;
        }

    }

