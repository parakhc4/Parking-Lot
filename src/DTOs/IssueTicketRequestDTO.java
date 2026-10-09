package DTOs;

import Models.Enums.Types.VehicleType;

public class IssueTicketRequestDTO {
    private Long operatorId;
    private String vehicleNumber;
    private String ownerName;
    private String ownerNumber;
    private VehicleType vehicleType;
    private Long regNo;

    public IssueTicketRequestDTO(Long operatorId, String vehicleNumber, String ownerName, String ownerNumber, VehicleType vehicleType) {
        this.operatorId = operatorId;
        this.vehicleNumber = vehicleNumber;
        this.ownerName = ownerName;
        this.ownerNumber = ownerNumber;
        this.vehicleType = vehicleType;
    }

    public Long getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(Long operatorId) {
        this.operatorId = operatorId;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getOwnerNumber() {
        return ownerNumber;
    }

    public void setOwnerNumber(String ownerNumber) {
        this.ownerNumber = ownerNumber;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

}
