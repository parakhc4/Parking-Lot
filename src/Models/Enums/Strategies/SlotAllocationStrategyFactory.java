package Models.Enums.Strategies;


import Models.Enums.Strategies.Enums.SlotAllocationStrategies;

public class SlotAllocationStrategyFactory {

    public static SlotAllotmentStrategy getStrategy(SlotAllocationStrategies strat){
        if (strat.equals(SlotAllocationStrategies.RANDOM)){
            return new RandomSlotAllocationStrategy();
        }
        else{
            throw new IllegalArgumentException("Invalid Slot allocation Strat!");
        }
    }
}