package Models;

import Models.Enums.Strategies.FeeCalculationStrategy;
import Models.Enums.Strategies.SlotAllotmentStrategy;

import java.util.List;

public class ParkingLot extends BaseModel{
    private String name;
    private List<ParkingFloor> floors;
    private List<AllowedVehicles> allowed_Vehicles;
    private List<Gate>entry_gate;
    private List<Gate>exit_gate;

    private FeeCalculationStrategy fee_calculation_strategy;
    private SlotAllotmentStrategy slot_allocation_strategy;
}