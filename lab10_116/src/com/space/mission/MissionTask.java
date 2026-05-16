package com.space.mission;

public class MissionTask {
   private String name;
private double requiredFuel;
 private int requiredExperience;
 private boolean isCompleted;

    public MissionTask(String name, double requiredFuel, int requiredExperience) {
        this.name = name;
        this.requiredFuel = requiredFuel;
        this.requiredExperience = requiredExperience;
        this.isCompleted = false;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRequiredFuel(double requiredFuel) {
        this.requiredFuel = requiredFuel;
    }

    public void setRequiredExperience(int requiredExperience) {
        this.requiredExperience = requiredExperience;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    public String getName() {
        return name;
    }

    public double getRequiredFuel() {
        return requiredFuel;
    }

    public int getRequiredExperience() {
        return requiredExperience;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    @Override
    public String toString() {
        return "MissionTask{" +
                "name='" + name + '\'' +
                ", requiredFuel=" + requiredFuel +
                ", requiredExperience=" + requiredExperience +
                ", isCompleted=" + isCompleted +
                '}';
    }
}
