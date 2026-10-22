package Strategies.FeeCalculation;

import Strategies.Enums.FeeCalculationStrategies;

public class FeeCalculationStrategyFactory {

    public static FeeCalculationStrategy getFeeCalculationStrategy(FeeCalculationStrategies strategy){
        switch (strategy){
            case HOURLY -> {
                return new HourlyFeeCalculationStrategy();
            }
            case FIXED -> {
                return new FixedFeeCalculationStrategy();
            }
            default -> {
                throw new RuntimeException("Unknown strategy");
            }
        }
    }
}
