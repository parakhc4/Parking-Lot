package Services;

import Models.Enums.Types.VehicleType;
import Models.Ticket;

public class TicketService {

    public Ticket issueTicket(Long operatorId, String vehicleNumber, String ownerName, String ownerNumber, VehicleType vehicleType){
        /* TODO : Creating ticket logic goes here Fetch the operator from ID check if operator exists. Fetch the gate from the operator
        // check if gate exists, and if it is an entry gate, and should be

        // Find or create vehicle

        // Available slot
        return null;
    }
}
