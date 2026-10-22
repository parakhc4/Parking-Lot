package Services;

import Models.*;
import Repository.InMemoryRepository;
import Strategies.FeeCalculation.FeeCalculationStrategyFactory;

import java.util.Date;

public class BillService {
    private InMemoryRepository<Operator> operatorDatabase;
    private InMemoryRepository<Bill> billDatabase;
    private InMemoryRepository<Ticket> ticketDatabase;

    public BillService(InMemoryRepository<Operator> operatorDatabase, InMemoryRepository<Bill> billDatabase, InMemoryRepository<Ticket> ticketDatabase) {
        this.operatorDatabase = operatorDatabase;
        this.billDatabase = billDatabase;
        this.ticketDatabase = ticketDatabase;
    }

    public Bill createBill(Long ticketId, Long operatorId ) {
        // Fetch the operator
        Operator operator = operatorDatabase.getById(operatorId);
        if (operator.equals(null)) throw new RuntimeException("Operator not found");

        // Fetch gate from operator
        Gate gate = operator.getGate();
        if (gate.equals(null)) throw new RuntimeException("Gate not found");

        // Fetch Ticket
        Ticket ticket = ticketDatabase.getById(ticketId);

        // get Gate
        ParkingLot parkingLot = gate.getParkingLot();
        if (parkingLot.equals(null)) throw new RuntimeException("Parking Lot not found");
        // Calculate fee amount

        double amount = FeeCalculationStrategyFactory.getFeeCalculationStrategy(parkingLot.getFee_calculation_strategy()).calculateFee(ticket.getEntryTime(), new Date(), ticket.getVehicle().getVehicleType());

        Bill bill =  new Bill();
        bill.setAmount(amount);
        bill.setGate(gate);
        bill.setOperator(operator);
        bill.setTicket(ticket);
        bill.setExit_time(new Date());
        return billDatabase.save(bill);

    }
}

