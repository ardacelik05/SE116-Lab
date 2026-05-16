package com.space.core;

import com.space.mission.MissionTask;

public class Astronaut {
    private String name;
    private int experienceLevel;

    @Override
    public String toString() {
        return "Astronaut{" +
                "name='" + name + '\'' +
                ", experienceLevel=" + experienceLevel +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setExperienceLevel(int experienceLevel) {
        this.experienceLevel = experienceLevel;
    }

    public String getName() {
        return name;
    }

    public int getExperienceLevel() {
        return experienceLevel;
    }

    public Astronaut(String name, int experienceLevel) {
        this.name = name;
        this.experienceLevel = experienceLevel;
    }

    public void performTask(MissionTask task){
        System.out.println("Astronout is attempting...");
        if (this.experienceLevel< task.getRequiredExperience()){
            throw new RuntimeException("Astronout "+ this.name+" does not have enough experience level.");
        }
        task.setCompleted(true);
        this.experienceLevel++;

        System.out.println("Mission is succesful!!");
    }
}
