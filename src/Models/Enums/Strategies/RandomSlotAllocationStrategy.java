package Models.Enums.Strategies;

import Models.Enums.Statuses.ParkingSlotStatus;
import Models.Enums.Types.VehicleType;
import Models.ParkingSlot;

import java.util.List;
import java.util.Random;

public class RandomSlotAllocationStrategy implements SlotAllotmentStrategy{

    Random random = new Random();
    @Override
//    public ParkingSlot findAvailableSlot(List<ParkingSlot> parkingSlots, VehicleType vehicleType) {
//        Integer len_of_slots = parkingSlots.size();
//        while(true){
//            ParkingSlot random_slot = parkingSlots.get(random.nextInt(0,len_of_slots));
//            if (random_slot.getStatus().equals(ParkingSlotStatus.FREE)){
//                return random_slot;
//                }
//            }
//        }

    // LESSON : This will end up in a infinite loop if all slots are full
    public ParkingSlot findAvailableSlot(List<ParkingSlot> parkingSlots, VehicleType vehicleType) {

        for (ParkingSlot slot : parkingSlots){
            if (slot.getStatus().equals(ParkingSlotStatus.FREE)&&slot.getVehicleType().equals(vehicleType)){
                return slot;
            }
        }

        return new ParkingSlot();
    }
    }
