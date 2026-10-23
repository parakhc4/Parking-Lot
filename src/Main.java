import Models.*;
import Repository.InMemoryRepository;
import Services.TicketService;
import Services.VehicleService;

public class Main {
    public static void main(String[] args) {
         InMemoryRepository<Operator> operatorDatabase = new InMemoryRepository<>();
         InMemoryRepository<Ticket> ticketDatabase = new InMemoryRepository<>();
         InMemoryRepository<ParkingSlot> parkingSlotDatabase = new InMemoryRepository<>();
         InMemoryRepository<ParkingLot> parkingLotDatabase = new InMemoryRepository<>();
         InMemoryRepository<ParkingFloor> parkingFloorDatabase = new InMemoryRepository<>();
         InMemoryRepository<AllowedVehicle> allowedVehicleDatabase = new InMemoryRepository<>();
         InMemoryRepository<Gate> gateDatabase = new InMemoryRepository<>();
        InMemoryRepository<Vehicle> vehicleDatabase = new InMemoryRepository<>();

        DataGenerator dataGenerator = new DataGenerator(operatorDatabase,ticketDatabase,parkingSlotDatabase,parkingLotDatabase,parkingFloorDatabase,allowedVehicleDatabase,gateDatabase);
        VehicleService vehicleService = new VehicleService(vehicleDatabase);
        TicketService ticketService = new TicketService(operatorDatabase,ticketDatabase,parkingSlotDatabase,vehicleService);
    }
}