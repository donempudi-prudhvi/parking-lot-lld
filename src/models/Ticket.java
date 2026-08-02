package models;

import java.time.LocalDateTime;

public class Ticket {
    private Vehicle vehicle;
    private LocalDateTime entryTime;
    private int floorNumber;
    private int slotId;

    public Ticket(Vehicle vehicle, LocalDateTime entryTime, int floorNumber, int slotId) {
        this.vehicle = vehicle;
        this.entryTime = entryTime;
        this.floorNumber = floorNumber;
        this.slotId = slotId;
    }
    public Vehicle getVehicle() {
        return vehicle;
    }
    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
    public LocalDateTime getEntryTime() {
        return entryTime;
    }
    public void setEntryTime(LocalDateTime entryTime) {
        this.entryTime = entryTime;
    }
    public int getFloorNumber() {
        return this.floorNumber;
    }
    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }
    public int getSlotId() {
        return slotId;
    }
    public void setSlotId(int slotId) {
        this.slotId = slotId;
    }
    
    

    
}
