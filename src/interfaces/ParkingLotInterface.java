package interfaces;

import models.Ticket;
import models.Vehicle;

public interface ParkingLotInterface {
    public Ticket entry(Vehicle vehicle);
    public double exit(Ticket ticket);
}
