import Models.*;
import Repository.InMemoryRepository;
import Services.TicketService;

public class Main {
    public static void main(String[] args) {
         InMemoryRepository<Operator> operatorDatabase = new InMemoryRepository<>();
         InMemoryRepository<Ticket> ticketDatabase = new InMemoryRepository<>();
         InMemoryRepository<ParkingSlot> parkingSlotDatabase = new InMemoryRepository<>();
         InMemoryRepository<ParkingLot> parkingLotDatabase = new InMemoryRepository<>();
         InMemoryRepository<ParkingFloor> parkingFloorDatabase = new InMemoryRepository<>();
         InMemoryRepository<AllowedVehicle> allowedVehicleDatabase = new InMemoryRepository<>();
         InMemoryRepository<Gate> gateDatabase = new InMemoryRepository<>();

        for (int i = 1; i <= 5; i++) {
            //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
            // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
            System.out.println("i = " + i);
        }
    }
}