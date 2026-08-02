package services;

import java.time.LocalDateTime;

import interfaces.ParkingAllocationStrategyInterface;
import models.ParkingFloor;
import models.ParkingSpace;
import models.Ticket;
import models.Vehicle;

public class ParkingAllocationStrategy implements ParkingAllocationStrategyInterface {
    
    ParkingLotImpl parkingLotImpl;

    public ParkingAllocationStrategy(ParkingLotImpl parkingFloorList){
        this.parkingLotImpl = parkingFloorList;
    } 
    
    public Ticket getAvailableSlot(Vehicle vehicle){
        
        for(ParkingFloor floor : this.parkingLotImpl.getParkingLot().getParkingFloorList()){
            if(!this.parkingLotImpl.getParkingFloorImpl().checkIsFull(floor.getFloorNumber())){
                for(ParkingSpace space : floor.getParkingSpaceList()){
                    if(space.getSlotType() == vehicle.getVehicleType()){
                        if(space.tryLock()){
                            Ticket t = new  Ticket(vehicle, LocalDateTime.now(), floor.getFloorNumber(), space.getSlotId());
                            this.parkingLotImpl.getParkingLot().addTicket(t);
                            return t;
                        }  

                    }
                }
            }
        }
        return null;
    }


    public boolean unparkVehicle(Ticket ticket){
    if(!this.parkingLotImpl.getParkingLot().containsMatchingTicket(ticket.getFloorNumber(), ticket.getSlotId())){
        return false;
    }
        for(ParkingFloor floor : this.parkingLotImpl.getParkingLot().getParkingFloorList()){
            if(floor.getFloorNumber() == ticket.getFloorNumber()){
                for(ParkingSpace space: floor.getParkingSpaceList()){
                    if(space.getSlotId() == ticket.getSlotId()){
                        this.parkingLotImpl.getParkingLot().removeTicket(ticket);
                        space.unPark();
                        break;
                    }
                }
                break;
            }
        }
        return true;
    }

    public boolean isTicketValid(Ticket ticket){
        for(Ticket t: this.parkingLotImpl.getParkingLot().getTickets()){
            if(t.getFloorNumber() == ticket.getFloorNumber() && t.getSlotId() == ticket.getSlotId()){
                return true;
            }
        }
        return false;
    }
}
