package Services;

import Models.*;
import Models.Enums.Statuses.GateStatus;
import Models.Enums.Statuses.ParkingSlotStatus;
import Models.Enums.Types.GateType;
import Models.Enums.Types.VehicleType;
import Repository.InMemoryRepository;
import Strategies.Enums.SlotAllocationStrategies;
import Strategies.SlotAllocationStrategyFactory;

import java.util.Date;
import java.util.List;

public class TicketService {

    private InMemoryRepository<Operator> operatorDatabase ;
    private InMemoryRepository<Ticket> ticketDatabase;
    private InMemoryRepository<ParkingSlot> parkingSlotDatabase;

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
        if (gate.getType().equals(GateType.EXIT)){
            throw new IllegalArgumentException("Invalid gate for ticket creation.");
        }
        if (!(gate.getStatus().equals(GateStatus.OPEN))){
            throw new RuntimeException("Gate is closed or unoperational");
        }

        // find and create a vehicle
        Vehicle vehicle = vehicleService.findOrCreate(vehicleNumber,ownerName,ownerNumber,vehicleType);


        // fetch parking lot from gate
        ParkingLot parkingLot = gate.getParkingLot();

        // fetch all slots
        List<ParkingSlot> allParkingSlots = parkingSlotDatabase.findAll(); // TODO : find all by parking lot

        // available slot - slot allocation strategy - parkingLot
        ParkingSlot availableSlot = SlotAllocationStrategyFactory
                .getStrategy(parkingLot.getSlot_allocation_strategy())
                .findAvailableSlot(allParkingSlots,vehicleType);
        // update the avl slot to filed
        availableSlot.setStatus(ParkingSlotStatus.TAKEN);

        // create and return a ticket
        Ticket ticket = new Ticket();
        ticket.setGate(gate);
        ticket.setVehicle(vehicle);
        ticket.setOperator(operator);
        ticket.setParkingSlot(availableSlot);
        ticket.setEntryTime(new Date());
        ticketDatabase.save(ticket);
        return ticket;
    }
}
