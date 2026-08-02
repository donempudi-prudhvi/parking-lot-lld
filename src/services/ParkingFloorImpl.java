package services;

import java.util.ArrayList;
import java.util.List;

import enums.SlotType;
import interfaces.ParkingFloorInterface;
import models.ParkingFloor;
import models.ParkingSpace;

public class ParkingFloorImpl implements ParkingFloorInterface{

    List<ParkingFloor> parkingFloorList;

    public ParkingFloorImpl(int twoWheelerSpaceCount, int fourWheelerSpaceCount, int eightWheelerSpaceCount, int numOfFloors){
        this.parkingFloorList = new ArrayList<>();
        for(int i = 1;i<=numOfFloors;i++){
            this.parkingFloorList.add(new ParkingFloor(twoWheelerSpaceCount, fourWheelerSpaceCount, eightWheelerSpaceCount, i));
        }
        
    }

    @Override
    public boolean checkIsFull(int floorNumber) {

        for(ParkingFloor floor: this.getParkingFloorList()){
            if(floor.getFloorNumber() == floorNumber){
                for(ParkingSpace space: floor.getParkingSpaceList()){
                    if(space.isAvailable()){
                        return false;
                    }
                }
            }
        }
        return true;
    }

    @Override
    public int getEightWheelerSpaceCount(int floorNumber) {
        int count = 0;

        for(ParkingFloor floor: this.getParkingFloorList()){
            if(floor.getFloorNumber() == floorNumber){
                for(ParkingSpace space: floor.getParkingSpaceList()){
                    if(space.isAvailable() && space.getSlotType() == SlotType.EIGHT_WHEELER){
                        count++;
                    }
                }
            }
        }
        
        return count;
    }

    @Override
    public int getFourWheelerSpaceCount(int floorNumber) {
        int count = 0;

        for(ParkingFloor floor: this.getParkingFloorList()){
            if(floor.getFloorNumber() == floorNumber){
                for(ParkingSpace space: floor.getParkingSpaceList()){
                    if(space.isAvailable() && space.getSlotType() == SlotType.FOUR_WHEELER){
                        count++;
                    }
                }
            }
        }
        
        return count;
    }

    @Override
    public int getTwoWheelerSpaceCount(int floorNumber) {
        int count = 0;

        for(ParkingFloor floor: this.getParkingFloorList()){
            if(floor.getFloorNumber() == floorNumber){
                for(ParkingSpace space: floor.getParkingSpaceList()){
                    if(space.isAvailable() && space.getSlotType() == SlotType.TWO_WHEELER){
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public List<ParkingFloor> getParkingFloorList() {
        return parkingFloorList;
    }

    public void setParkingFloorList(List<ParkingFloor> parkingFloorList) {
        this.parkingFloorList = parkingFloorList;
    }

    

    
    
}
