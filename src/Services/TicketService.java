package Services;

import Models.*;
import Models.Enums.Statuses.GateStatus;
import Models.Enums.Types.GateType;
import Models.Enums.Types.VehicleType;
import Repository.InMemoryRepository;

public class TicketService {

    private InMemoryRepository<Operator> operatorDatabase ;
    private InMemoryRepository<Vehicle> vehicleDatabase;
    private VehicleService vehicleService;

    public Ticket issueTicket(Long operatorId, String vehicleNumber, String ownerName, String ownerNumber, VehicleType vehicleType){
        /* TODO : Creating ticket logic goes here Fetch the operator from ID check if operator exists. Fetch the gate from the operator
        */

        // get the operator by id
        Operator operator = operatorDatabase.getById(operatorId);                                                   // TODO : Update findById to return optional ?

        // check if operator exists
        if (operator == null){
            throw new RuntimeException("Operator not found");
        }

        // fetch the gate from operator
        Gate gate = operator.getGate();

        /* LESSON a very interesting thing told by the instructor.
             This is an in memory db, so we are storing the entire Gate gate object in the Operator class.
             But in actual DB, you wouldn't want to do that. There, you need to do a loookup by using the foreign key.
              And that is all you store in the Parent Class.
              So there, GateID gateId will be there in Operator, and when you do gate = operator.getGate, ORM does SELECT * FROM gate WHERE id = ?

            ex: OPERATOR = id | name | ... | gateID
            GATE = id | name
           you query the gate's id using gateId
         */


        // check if gate exists and gate should be an entry gate
        if (gate == null){
            throw new RuntimeException("No valid gate found for operator");
        }
        if (gate.getType()!= GateType.EXIT){
            throw new IllegalArgumentException("Invalid gate for ticket creation.");
        }
        if (gate.getStatus()!= GateStatus.OPEN){
            throw new RuntimeException("Gate is closed or unoperational");
        }

        // find and create a vehicle
        vehicleService.findOrCreate(vehicleNumber,ownerName,ownerNumber,vehicleType);


        // fetch parking lot from gate
        ParkingLot parkingLot = gate.getParkingLot();

        // available slot - slot allocation strategy - parkingLot
        ParkingSlot availableSlot = null;
        // update the avl slot to filed

        // create and return a ticket

        return null;
    }
}
