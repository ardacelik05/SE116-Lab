package com.space.core;

import com.space.exceptions.InsufficientFuelException;
import com.space.mission.MissionTask;

public class Spacecraft {
    private String craftName;
    private int fuelLevel;

    public Spacecraft(String craftName, int fuelLevel) {
        this.craftName = craftName;
        this.fuelLevel = fuelLevel;
    }

    public void setCraftName(String craftName) {
        this.craftName = craftName;
    }

    public void setFuelLevel(int fuelLevel) {
        this.fuelLevel = fuelLevel;
    }

    public String getCraftName() {
        return craftName;
    }

    public int getFuelLevel() {
        return fuelLevel;
    }

    @Override
    public String toString() {
        return "Spacecraft{" +
                "craftName='" + craftName + '\'' +
                ", fuelLevel=" + fuelLevel +
                '}';
    }
    public void executeTask(MissionTask task) throws InsufficientFuelException {
    if(this.fuelLevel<task.getRequiredFuel()){
    throw new InsufficientFuelException();
}
    this.fuelLevel-=task.getRequiredFuel();
        System.out.println("task completed succesfully. Kalan yakıt " + this.fuelLevel );
    }
}
