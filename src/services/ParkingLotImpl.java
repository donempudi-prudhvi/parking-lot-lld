package services;

import interfaces.ParkingLotInterface;
import models.ParkingLot;
import models.Ticket;
import models.Vehicle;

public class ParkingLotImpl implements ParkingLotInterface {

    ParkingFloorImpl parkingFloorImpl; 
    ParkingLot parkingLot;
    FareCalculationStrategy fareCalculationStrategy;
    ParkingAllocationStrategy parkingAllocationStrategy;

    public ParkingLotImpl(ParkingFloorImpl parkingFloorImpl){
        this.parkingFloorImpl = parkingFloorImpl;
        this.parkingLot = new ParkingLot(parkingFloorImpl.getParkingFloorList());
        this.fareCalculationStrategy = new FareCalculationStrategy(this);
        this.parkingAllocationStrategy = new ParkingAllocationStrategy(this);

    }

    @Override
    public Ticket entry(Vehicle vehicle){
        return this.parkingAllocationStrategy.getAvailableSlot(vehicle); 
    }

    @Override
    public double exit(Ticket ticket){
        if(this.parkingAllocationStrategy.unparkVehicle(ticket)){
            return this.fareCalculationStrategy.getFare(ticket);
        }
        return -1;
    }


    public ParkingFloorImpl getParkingFloorImpl() {
        return parkingFloorImpl;
    }

    public void setParkingFloorImpl(ParkingFloorImpl parkingFloorImpl) {
        this.parkingFloorImpl = parkingFloorImpl;
    }

    public ParkingLot getParkingLot() {
        return parkingLot;
    }

    public void setParkingLot(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

        public FareCalculationStrategy getFareCalculationStrategy() {
        return fareCalculationStrategy;
    }

    public void setFareCalculationStrategy(FareCalculationStrategy fareCalculationStrategy) {
        this.fareCalculationStrategy = fareCalculationStrategy;
    }

    public ParkingAllocationStrategy getParkingAllocationStrategy() {
        return parkingAllocationStrategy;
    }

    public void setParkingAllocationStrategy(ParkingAllocationStrategy parkingAllocationStrategy) {
        this.parkingAllocationStrategy = parkingAllocationStrategy;
    }
    
    
}
