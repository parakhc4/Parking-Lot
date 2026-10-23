import Controllers.TicketController;
import DTOs.IssueTicketRequestDTO;
import DTOs.IssueTicketResponseDTO;
import Models.*;
import Models.Enums.Types.VehicleType;
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
        dataGenerator.generateData();
        VehicleService vehicleService = new VehicleService(vehicleDatabase);
        TicketService ticketService = new TicketService(operatorDatabase,ticketDatabase,parkingSlotDatabase,vehicleService);
        TicketController controller = new TicketController(ticketService);

        IssueTicketRequestDTO requestDTO = new IssueTicketRequestDTO(1l,"MP04YD2153","Parakh","8316934863", VehicleType.BIKE, 102l);
        IssueTicketResponseDTO responseDTO = controller.issueTicket(requestDTO);
        System.out.println(responseDTO.toString());
        System.out.println(responseDTO.getMessage());

        requestDTO = new IssueTicketRequestDTO(1l,"MP04YD2154","Hambdar","96840298386", VehicleType.BIKE, 102l);
        responseDTO = controller.issueTicket(requestDTO);
        System.out.println(responseDTO.toString());
        System.out.println(responseDTO.getMessage());

        try {
            requestDTO = new IssueTicketRequestDTO(1l, "MP04YD2154", "Hambdar", "96840298386", VehicleType.BIKE, 102l);
            responseDTO = controller.issueTicket(requestDTO);
            System.out.println(responseDTO.toString());
            System.out.println(responseDTO.getMessage());
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }

    }
}