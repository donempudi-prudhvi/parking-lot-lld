package interfaces;

import models.Ticket;
import models.Vehicle;

public interface ParkingAllocationStrategyInterface {
    Ticket getAvailableSlot(Vehicle vehicle);
    boolean unparkVehicle(Ticket ticket);
    boolean isTicketValid(Ticket ticket);

}
