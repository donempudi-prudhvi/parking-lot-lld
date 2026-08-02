package models;

import java.util.ArrayList;
import java.util.List;

import enums.SlotType;

public class ParkingFloor {
    private List<ParkingSpace> parkingSpaceList;
    private boolean isFull;
    private int floorNumber;
    private int twoWheelerSpaceCount;
    private int fourWheelerSpaceCount;
    private int eightWheelerSpaceCount;
    
    public ParkingFloor(int twoWheelerSpaceCount, int fourWheelerSpaceCount, int eightWheelerSpaceCount, int floorNumber){
        
        this.twoWheelerSpaceCount = twoWheelerSpaceCount;
        this.fourWheelerSpaceCount = fourWheelerSpaceCount;
        this.eightWheelerSpaceCount = eightWheelerSpaceCount;
        this.floorNumber = floorNumber;
        parkingSpaceList = new ArrayList<>();
        int slotId = 0;

        for(int i=0;i<twoWheelerSpaceCount;i++){
            parkingSpaceList.add(new ParkingSpace(true, SlotType.TWO_WHEELER,slotId++));
        }
        for(int i=0;i<fourWheelerSpaceCount;i++){
            parkingSpaceList.add(new ParkingSpace(true, SlotType.FOUR_WHEELER,slotId++));
        }
        for(int i=0;i<eightWheelerSpaceCount;i++){
            parkingSpaceList.add(new ParkingSpace(true, SlotType.EIGHT_WHEELER,slotId++));
        }
    }

    public List<ParkingSpace> getParkingSpaceList() {
        return parkingSpaceList;
    }

    public void setParkingSpaceList(List<ParkingSpace> parkingSpaceList) {
        this.parkingSpaceList = parkingSpaceList;
    }

    public boolean isFull(){
        return isFull;
    }

    public void setFull(boolean isFull) {
        this.isFull = isFull;
    }


    public int getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }



}
