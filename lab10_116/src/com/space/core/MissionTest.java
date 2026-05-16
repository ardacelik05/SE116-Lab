package com.space.core;

import com.space.exceptions.MissionDataException;
import com.space.mission.MissionTask;

public class MissionTest {
    public static void main(String[] args) {
        Spacecraft titanic = new Spacecraft("Titanic", 30);
        Spacecraft mayis = new Spacecraft("19 Mayıs", 110);

        Astronaut a1 = new Astronaut("George", 15);
        Astronaut a2 = new Astronaut("Alex", 22);

        MissionControl control = new MissionControl("Go to Space");

        MissionTask task1 = new MissionTask("Launch", 29.0, 24);
        MissionTask task2 = new MissionTask("Mars exploration", 22.2, 10);
        MissionTask task3 = new MissionTask("Mining operation", 22.1, 33);


        control.addSpacecraft(titanic);
        control.addSpacecraft(mayis);

        control.addAstronaut(a1);
        control.addAstronaut(a2);
        System.out.println("\n-------------------------------------\n");
        System.out.println("Step 2: Printing current mission members:");
        control.printMissionMembers();
        System.out.println("\n-------------------------------------\n");

        control.removeAstronaut("Alex");
        control.removeSpacecraft("Titanic");
        control.printMissionMembers();
        control.addSpacecraft(titanic);
        control.addAstronaut(a2);
        System.out.println("\n-------------------------------------\n");


// testing exception
        System.out.println("Step 5: Testing Fuel Shortage Exception:");
        try {
            control.launchTask("19 Mayıs", "Alex", task2);
        } catch (MissionDataException e) {
            System.out.println(e.getMessage());
            System.out.println("Cause: " + e.getCause());
        }

        System.out.println("\n-------------------------------------\n");

        System.out.println("Step 6: Testing missing astronut or spacecraft");
        try {
            control.launchTask("19 Mayıs", "Arda", task1);
        } catch (MissionDataException e) {
            System.out.println(e.getMessage());
            System.out.println("Cause: " + e.getCause());
        }

        System.out.println("\n-------------------------------------\n");
        System.out.println("Test 7: Testing Low Experience Exception: ");
        try {
            control.launchTask("19 Mayıs", "Alex", task1);
        } catch (MissionDataException e) {
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
        }

        System.out.println("\n-------------------------------------\n");

        System.out.println("Step 8: Catching and printing Chained Exception details:");
        try {
            control.launchTask("Geçersiz Gemi", "Alex", task1);
        }catch (MissionDataException e){
            System.out.println(e.getMessage());
            System.out.println("Cause: " + e.getCause());
        }
        System.out.println("\n-------------------------------------\n");

        System.out.println("Step 9: Calling exportMissionLog()...");
        String sampleLog = " Simulation completed. Checked successful launches, fuel shortages, and missing resources.";
        control.exportMissionLog(sampleLog);
    }
}
