package Services;

import Models.Enums.Types.VehicleType;
import Models.Vehicle;
import Repository.InMemoryRepository;

import java.util.ArrayList;
import java.util.List;

public class VehicleService {
    InMemoryRepository<Vehicle> vehicleRepository;

    public VehicleService(InMemoryRepository<Vehicle> vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    public Vehicle findOrCreate(String vehicleNumber, String ownerName, String ownerNumber, VehicleType vehicleType){
        List<Vehicle> vehicles = new ArrayList<>();

        for(Vehicle vehicle:vehicleRepository.findAll()){
            if (vehicle.getReg_number().equalsIgnoreCase(vehicleNumber)){
                return vehicle;
            }
        }
        Vehicle vehicle = new Vehicle(vehicleNumber,ownerName,ownerNumber,vehicleType);
        return vehicleRepository.save(vehicle);
    }
}

