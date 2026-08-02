import enums.SlotType;
import models.Ticket;
import models.Vehicle;
import services.DisplayBoardImpl;
import services.ParkingFloorImpl;
import services.ParkingLotImpl;

public class App {
    public static void main(String[] args) throws Exception {
    
        ParkingFloorImpl parkingFloorImpl = new ParkingFloorImpl(10, 4, 5, 1);
        ParkingLotImpl parkingLotImpl = new ParkingLotImpl(parkingFloorImpl);
    

        DisplayBoardImpl displayBoardImpl = new DisplayBoardImpl(parkingLotImpl);
        System.out.println("----------------------------------------------------");
        displayBoardImpl.display();
        System.out.println("----------------------------------------------------\n");

        Vehicle v2 = new Vehicle(SlotType.TWO_WHEELER);
        Vehicle v22 = new Vehicle(SlotType.TWO_WHEELER);

        Vehicle v4 = new Vehicle(SlotType.FOUR_WHEELER);
        Vehicle v44 = new Vehicle(SlotType.FOUR_WHEELER);

        Vehicle v8 = new Vehicle(SlotType.EIGHT_WHEELER);
        Vehicle v88 = new Vehicle(SlotType.EIGHT_WHEELER);
        
        Ticket t1 = parkingLotImpl.entry(v88);
        System.out.println("Vehicle parked at :" + t1.getFloorNumber() +" floor - " + t1.getSlotId()  + " slot, at " + t1.getEntryTime());
        Ticket t2 = parkingLotImpl.entry(v44);
        System.out.println("Vehicle parked at :" + t2.getFloorNumber() +" floor - " + t2.getSlotId()  + " slot, at " + t2.getEntryTime());
        Ticket t3 = parkingLotImpl.entry(v2);
        System.out.println("Vehicle parked at :" + t3.getFloorNumber() +" floor - " + t3.getSlotId()  + " slot, at " + t3.getEntryTime());

        System.out.println("----------------------------------------------------");
        displayBoardImpl.display();
        System.out.println("----------------------------------------------------\n");

        double amount1 = parkingLotImpl.exit(t3);
        if(amount1 > -1){
            System.out.println("Amount to be paid : " + amount1);
        }else{
            System.out.println("Invalid Ticket, check at the counter");
        }
        double amount2 = parkingLotImpl.exit(t1);
        if(amount2 > -1){
            System.out.println("Amount to be paid : " + amount2);
        }else{
            System.out.println("Invalid Ticket, check at the counter");
        }
        double amount3 = parkingLotImpl.exit(t2);
        if(amount3 > -1){
            System.out.println("Amount to be paid : " + amount3);
        }else{
            System.out.println("Invalid Ticket, check at the counter");
        }

        amount1 = parkingLotImpl.exit(t3);
        
        if(amount1 > -1){
            System.out.println("Amount to be paid : " + amount1);
        }else{
            System.out.println("Invalid Ticket, check at the counter");
        }
        



        
    }
}
