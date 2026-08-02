package models;

import enums.SlotType;

public class Vehicle {
    private SlotType vehicleType;

    public Vehicle(SlotType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public SlotType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(SlotType vehicleType) {
        this.vehicleType = vehicleType;
    }
    
    
}
