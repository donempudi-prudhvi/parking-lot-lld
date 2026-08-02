package models;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;


public class ParkingLot {
    
    private List<ParkingFloor> parkingFloorList;
    private List<Ticket> tickets;
    private final ReentrantLock ticketsLock = new ReentrantLock();

    public ParkingLot(List<ParkingFloor> parkingFloorList) {
        this.parkingFloorList = parkingFloorList;
        this.tickets = new ArrayList<>();
    }

    public void addTicket(Ticket t) {
        ticketsLock.lock();
        try { tickets.add(t); }
        finally { ticketsLock.unlock(); }
    }

    public boolean removeTicket(Ticket t) {
        ticketsLock.lock();
        try { return tickets.remove(t); }
        finally { ticketsLock.unlock(); }
    }

    public boolean containsMatchingTicket(int floorNumber, int slotId) {
        ticketsLock.lock();
        try {
            for (Ticket t : tickets) {
                if (t.getFloorNumber() == floorNumber && t.getSlotId() == slotId) return true;
            }
            return false;
        } finally { ticketsLock.unlock(); }
    }

    public List<ParkingFloor> getParkingFloorList() {
        return parkingFloorList;
    }

    public void setParkingFloorList(List<ParkingFloor> parkingFloorList) {
        this.parkingFloorList = parkingFloorList;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }
    
}
