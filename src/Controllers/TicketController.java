package Controllers;

import DTOs.IssueTicketRequestDTO;
import DTOs.IssueTicketResponseDTO;
import Models.Enums.Statuses.ResponseStatus;
import Models.Ticket;
import Services.TicketService;

public class TicketController {

    //    issueTicket(Long operatorId, String vehicleNumber, String ownerName, String ownerNumber, VehicleType vehicleType);
    /* LESSON : This is the entrypoint of the code. Hence, you shouldn't take something like VehicleType
        Also, you don't want multiple comma separated inputs, there can be order issues
        We want all of them to be CLUBBED together in a DTO (Data Transfer Object)
    */

    //    Ticket issueTicket(IssueTicketRequestDTO)

    /* LESSON : The problem with returning a TICKET from controller is that it might leak the TICKET object to unwanted places.
        SO, return a DTO itself! */
    TicketService ticketService;

    public TicketController(TicketService ticketService){
        this.ticketService=ticketService;
    }

    public IssueTicketResponseDTO issueTicket(IssueTicketRequestDTO requestDTO) throws RuntimeException{

        IssueTicketResponseDTO responseDTO = new IssueTicketResponseDTO();
        try{
            Ticket ticket = ticketService.issueTicket(
                    requestDTO.getOperatorId(),
                    requestDTO.getOwnerName(),
                    requestDTO.getOwnerNumber(),
                    requestDTO.getOwnerName(),
                    requestDTO.getVehicleType()
                    );

            responseDTO.setTicketId(ticket.getId());
            responseDTO.setTicketNumber(ticket.getNumber());
            responseDTO.setEntryTime(ticket.getEntryTime());
            responseDTO.setMessage("Ticket issued sucessfully");
            responseDTO.setResponseStatus(ResponseStatus.SUCCESS);

        }catch(Exception e){
            throw new RuntimeException("No Available Parking Slots");
        }

        return responseDTO;
    }


}