import Models.*;
import Models.Enums.Statuses.GateStatus;
import Models.Enums.Statuses.ParkingFloorStatus;
import Models.Enums.Statuses.ParkingSlotStatus;
import Models.Enums.Types.GateType;
import Models.Enums.Types.VehicleType;
import Repository.InMemoryRepository;
import Strategies.Enums.FeeCalculationStrategies;
import Strategies.Enums.SlotAllocationStrategies;

import java.util.List;

public class DataGenerator {

    private InMemoryRepository<Operator> operatorDatabase ;
    private InMemoryRepository<Ticket> ticketDatabase;
    private InMemoryRepository<ParkingSlot> parkingSlotDatabase;
    private InMemoryRepository<ParkingLot> parkingLotDatabase;
    private InMemoryRepository<ParkingFloor> parkingFloorDatabase;
    private InMemoryRepository<AllowedVehicle> allowedVehicleDatabase;
    private InMemoryRepository<Gate> gateDatabase;

    public DataGenerator(InMemoryRepository<Operator> operatorDatabase, InMemoryRepository<Ticket> ticketDatabase, InMemoryRepository<ParkingSlot> parkingSlotDatabase, InMemoryRepository<ParkingLot> parkingLotDatabase, InMemoryRepository<ParkingFloor> parkingFloorDatabase, InMemoryRepository<AllowedVehicle> allowedVehicleDatabase,  InMemoryRepository<Gate> gateDatabase) {
        this.operatorDatabase = operatorDatabase;
        this.ticketDatabase = ticketDatabase;
        this.parkingSlotDatabase = parkingSlotDatabase;
        this.parkingLotDatabase = parkingLotDatabase;
        this.parkingFloorDatabase = parkingFloorDatabase;
        this.allowedVehicleDatabase = allowedVehicleDatabase;
        this.gateDatabase = gateDatabase;
    }

    public void generateData(){
        // 1 parking lot
        ParkingLot parkingLot = new ParkingLot("Parakh's Garage", FeeCalculationStrategies.HOURLY, SlotAllocationStrategies.RANDOM);
//        parkingLot.setFloors();
//        parkingLot.setAllowed_Vehicles();
//        parkingLot.setEntry_gate();
//        parkingLot.setExit_gate();

        // 2 parking floors
        ParkingFloor parkingFloor1 = new ParkingFloor(1, ParkingFloorStatus.EMPTY);
//        parkingFloor1.setParkingSlots();
//        parkingFloor1.setAllowedVehicles();

        ParkingFloor parkingFloor2 = new ParkingFloor(2, ParkingFloorStatus.EMPTY);
//        parkingFloor2.setParkingSlots();
//        parkingFloor2.setAllowedVehicles();

        // 4 parking slots
        ParkingSlot parkingSlot1A = new ParkingSlot("1A", ParkingSlotStatus.FREE, VehicleType.BIKE);
        ParkingSlot parkingSlot1B = new ParkingSlot("1B", ParkingSlotStatus.FREE, VehicleType.CAR);
        ParkingSlot parkingSlot2A = new ParkingSlot("2A", ParkingSlotStatus.FREE, VehicleType.BIKE);
        ParkingSlot parkingSlot2B = new ParkingSlot("2B", ParkingSlotStatus.FREE, VehicleType.CAR);

        // 2 gates
        Gate entryGate = new Gate(1, GateType.ENTRY, GateStatus.OPEN);
        entryGate.setParkingLot(parkingLot);
//        entryGate.setOperator();
        Gate exitGate = new Gate(2, GateType.EXIT, GateStatus.OPEN);
        exitGate.setParkingLot(parkingLot);
//        exitGate.setOperator();

        // 2 operators
        Operator entryOperator = new Operator("Amazon Google","B001");
        entryOperator.setGate(entryGate);

        Operator exitOperator = new Operator("Microsoft Zepto", "B002");
        exitOperator.setGate(exitGate);


        // allowed vehicles
        AllowedVehicle parkingLotCar = new AllowedVehicle(VehicleType.CAR, 2);
        AllowedVehicle parkingLotBike = new AllowedVehicle(VehicleType.BIKE, 2);



        parkingLot.setFloors(List.of(parkingFloor1,parkingFloor2));
        parkingLot.setAllowed_Vehicles(List.of(parkingLotCar,parkingLotBike));
        parkingLot.setEntry_gate(List.of(entryGate));
        parkingLot.setExit_gate(List.of(exitGate));

        parkingFloor1.setParkingSlots(List.of(parkingSlot1A,parkingSlot1B));
        parkingFloor1.setAllowedVehicles(List.of(parkingLotCar,parkingLotBike));

        parkingFloor2.setParkingSlots(List.of(parkingSlot2A, parkingSlot2B));
        parkingFloor2.setAllowedVehicles(List.of(parkingLotCar,parkingLotBike));

        entryGate.setOperator(entryOperator);

        exitGate.setOperator(exitOperator);

        parkingLotDatabase.save(parkingLot);
        parkingSlotDatabase.save(parkingSlot1A);
        parkingSlotDatabase.save(parkingSlot1B);
        parkingSlotDatabase.save(parkingSlot2A);
        parkingSlotDatabase.save(parkingSlot2B);

        operatorDatabase.save(entryOperator);
        operatorDatabase.save(exitOperator);

        parkingFloorDatabase.save(parkingFloor1);
        parkingFloorDatabase.save(parkingFloor2);

        gateDatabase.save(entryGate);
        gateDatabase.save(exitGate);

    }
}
