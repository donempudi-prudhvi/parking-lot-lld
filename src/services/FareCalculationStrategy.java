package services;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import enums.SlotType;
import interfaces.FareCalculationStrategyInterface;
import models.Ticket;

public class FareCalculationStrategy implements FareCalculationStrategyInterface{
    Map<SlotType, Double> rates;
    
    ParkingLotImpl parkingLotImpl;


    public FareCalculationStrategy(ParkingLotImpl parkingLotImpl){
        rates = new HashMap<>();
        rates.put(SlotType.TWO_WHEELER, 10.0);
        rates.put(SlotType.FOUR_WHEELER, 15.50);
        rates.put(SlotType.EIGHT_WHEELER, 50.75);

        this.parkingLotImpl = parkingLotImpl;

    }

    public double getFare(Ticket ticket){

        LocalDateTime startTime = ticket.getEntryTime();
        LocalDateTime now = LocalDateTime.now();
        long hours = Duration.between(startTime, now).toHours();
        if(hours == 0){
            return this.getRates().get(ticket.getVehicle().getVehicleType());
        }
        return hours*this.getRates().get(ticket.getVehicle().getVehicleType());
        
    }

    public Map<SlotType, Double> getRates() {
        return rates;
    }

    public void setRates(Map<SlotType, Double> rates) {
        this.rates = rates;
    }

    public ParkingLotImpl getParkingLotImpl() {
        return parkingLotImpl;
    }

    public void setParkingLotImpl(ParkingLotImpl parkingLotImpl) {
        this.parkingLotImpl = parkingLotImpl;
    }
    

}
