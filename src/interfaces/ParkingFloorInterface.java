package interfaces;

import models.ParkingSpace;

public interface ParkingFloorInterface {
    public boolean checkIsFull(int fn);
    public int getTwoWheelerSpaceCount(int fn);
    public int getFourWheelerSpaceCount(int fn);
    public int getEightWheelerSpaceCount(int fn);
}
