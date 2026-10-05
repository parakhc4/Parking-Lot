package Controllers;

import DTOs.IssueTicketRequestDTO;
import DTOs.IssueTicketResponseDTO;
import Models.Enums.Types.VehicleType;
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
        SO, return a DTO itself!
     */
    TicketService ticketService;

    public TicketController(TicketService ticketService){
        this.ticketService=ticketService;
    }

    IssueTicketResponseDTO issueTicket(IssueTicketRequestDTO requestDTO){
        IssueTicketResponseDTO responseDTO = new IssueTicketResponseDTO();

        try{
            Ticket ticket = ticketService.issueTicket(
                    requestDTO.getOperatorId(),
                    requestDTO.getRegNumber(),
                    requestDTO.getOwnerNumber(),
                    requestDTO.getOwnerName(),
                    requestDTO.getVehicleType()
                    );
        }catch(Exception e){

        }
    }


}