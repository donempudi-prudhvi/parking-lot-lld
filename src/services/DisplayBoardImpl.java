package services;

import interfaces.DisplayBoardInterface;
import models.ParkingFloor;

public class DisplayBoardImpl implements DisplayBoardInterface {

    ParkingLotImpl parkingLotImpl;

    public DisplayBoardImpl(ParkingLotImpl parkingLotImpl){
        this.parkingLotImpl = parkingLotImpl;
    }

    @Override
        public void display(){
            for(ParkingFloor floor : this.parkingLotImpl.getParkingFloorImpl().getParkingFloorList()){
                System.out.println("Floor : " + floor.getFloorNumber() + " has below slots available");
                System.out.println("Two Wheelers ** " + this.parkingLotImpl.getParkingFloorImpl().getTwoWheelerSpaceCount(floor.getFloorNumber()));
                System.out.println("Four Wheelers **** " +  this.parkingLotImpl.getParkingFloorImpl().getFourWheelerSpaceCount(floor.getFloorNumber()));
                System.out.println("Eight Wheelers ******** " + this.parkingLotImpl.getParkingFloorImpl().getEightWheelerSpaceCount(floor.getFloorNumber()) );
            }
        }
    
    
}
