package models;

import java.util.concurrent.locks.ReentrantLock;

import enums.SlotType;

public class ParkingSpace {
    private boolean isAvailable;
    private SlotType slotType;
    private int slotId;
    private final ReentrantLock lock = new ReentrantLock();

    public ParkingSpace(boolean isAvailable, SlotType slotType, int slotId) {
        this.isAvailable = isAvailable;
        this.slotType = slotType;
        this.slotId = slotId;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    public SlotType getSlotType() {
        return slotType;
    }

    public void setSlotType(SlotType slotType) {
        this.slotType = slotType;
    }

    public int getSlotId() {
        return slotId;
    }

    public void setSlotId(int slotId) {
        this.slotId = slotId;
    }

    public boolean tryLock(){
        lock.lock();
        try{
            if(!isAvailable()) return false;
            this.setAvailable(false);
            return true;
        }finally{
            lock.unlock();
        }
    }
    public void unPark(){
        lock.lock();
        try{
            this.setAvailable(true);
        }finally{
            lock.unlock();
        }
    }

    
}
