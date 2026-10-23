package Models;

import Strategies.Enums.SlotAllocationStrategies;
import Strategies.Enums.FeeCalculationStrategies;

import java.util.List;

public class ParkingLot extends BaseModel{
    private String name;
    private List<ParkingFloor> floors;
    private List<AllowedVehicle> allowed_Vehicles;
    private List<Gate>entry_gate;
    private List<Gate>exit_gate;

    private FeeCalculationStrategies fee_calculation_strategy;
    private SlotAllocationStrategies slot_allocation_strategy;

    public ParkingLot(String name, FeeCalculationStrategies fee_calculation_strategy, SlotAllocationStrategies slot_allocation_strategy) {
        this.fee_calculation_strategy = fee_calculation_strategy;
        this.slot_allocation_strategy = slot_allocation_strategy;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ParkingFloor> getFloors() {
        return floors;
    }

    public void setFloors(List<ParkingFloor> floors) {
        this.floors = floors;
    }

    public List<AllowedVehicle> getAllowed_Vehicles() {
        return allowed_Vehicles;
    }

    public void setAllowed_Vehicles(List<AllowedVehicle> allowed_Vehicles) {
        this.allowed_Vehicles = allowed_Vehicles;
    }

    public List<Gate> getEntry_gate() {
        return entry_gate;
    }

    public void setEntry_gate(List<Gate> entry_gate) {
        this.entry_gate = entry_gate;
    }

    public List<Gate> getExit_gate() {
        return exit_gate;
    }

    public void setExit_gate(List<Gate> exit_gate) {
        this.exit_gate = exit_gate;
    }

    public FeeCalculationStrategies getFee_calculation_strategy() {
        return fee_calculation_strategy;
    }

    public void setFee_calculation_strategy(FeeCalculationStrategies fee_calculation_strategy) {
        this.fee_calculation_strategy = fee_calculation_strategy;
    }

    public void setSlot_allocation_strategy(SlotAllocationStrategies slot_allocation_strategy) {
        this.slot_allocation_strategy = slot_allocation_strategy;
    }

    public ParkingLot(String name, List<ParkingFloor> floors, List<AllowedVehicle> allowed_Vehicles, List<Gate> entry_gate, List<Gate> exit_gate, FeeCalculationStrategies fee_calculation_strategy, SlotAllocationStrategies slot_allocation_strategy) {
        this.name = name;
        this.floors = floors;
        this.allowed_Vehicles = allowed_Vehicles;
        this.entry_gate = entry_gate;
        this.exit_gate = exit_gate;
        this.fee_calculation_strategy = fee_calculation_strategy;
        this.slot_allocation_strategy = slot_allocation_strategy;
    }

    public SlotAllocationStrategies getSlot_allocation_strategy(){
        return this.slot_allocation_strategy;
    }
}