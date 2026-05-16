package com.space.core;
import com.space.exceptions.InsufficientFuelException;
import com.space.exceptions.MissionDataException;
import com.space.mission.MissionTask;
import com.space.core.Astronaut;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class MissionControl {
    private String missionName;
    private ArrayList<Spacecraft> spacecrafts;
    private ArrayList<Astronaut> astronauts;

    public MissionControl(String missionName) {
        this.missionName = missionName;
        this.spacecrafts = new ArrayList<>();
        this.astronauts = new ArrayList<>();
    }
    public void addSpacecraft(Spacecraft gemi){
    this.spacecrafts.add(gemi);
        System.out.println(gemi.getCraftName()+ " Added to list.");
    }
    public void removeSpacecraft(String craftName){
        Spacecraft silincekGemi = getSpacecraft(craftName);

        if(silincekGemi != null){
            this.spacecrafts.remove(silincekGemi);
            System.out.println(craftName + " succesfully removed from list.");
        } else {
            System.out.println("Error: " + craftName + " not found in the list, cannot remove ");
        }
    }
    public void addAstronaut(Astronaut astronaut){
        this.astronauts.add(astronaut);
        System.out.println(astronaut.getName() + " Added to list.");
    }
    public void removeAstronaut(String astronautName){
        Astronaut bulunanaAstro = getAstronaut(astronautName);

        if (bulunanaAstro != null) {
            this.astronauts.remove(bulunanaAstro); // Nesnenin kendisini sildik!
            System.out.println(astronautName + " successfully removed from list.");
        } else {
            System.out.println("Error: " + astronautName + " not found in the list, cannot remove.");
        }
    }
    public void printMissionMembers(){
        System.out.println("Astranouts: " + astronauts);
        System.out.println("Spacecrafts: " + spacecrafts);
    }
    public Astronaut getAstronaut(String astronautName){
for (Astronaut astro: this.astronauts){
    if(astro.getName().equals(astronautName)){
        return astro;
    }
}
        return null;
    }

    public Spacecraft getSpacecraft(String craftName){
        for(Spacecraft craft:this.spacecrafts){
            if(craft.getCraftName().equals(craftName)){
                return craft;
            }
        }
        return null;

    }

    public void launchTask(String craftName, String astronautName, MissionTask task) throws MissionDataException {
        try {
            Spacecraft craft = getSpacecraft(craftName);
            Astronaut astro = getAstronaut(astronautName);

            System.out.println("Mission started: " + task.getName());

            //asertion
            double startingFuel = craft.getFuelLevel();
            int startingExperience = astro.getExperienceLevel();

            craft.executeTask(task);
            astro.performTask(task);

            //asertions
            assert craft.getFuelLevel() >=0 :"Assertion failled: spacecraft fuel level is negative";
            assert task.isCompleted() : "Assertion failled: Task is not marked as complited";
            assert astro.getExperienceLevel() >startingExperience : "Assertion Failed: Astronaut experience did not increase!";

            System.out.println("Mission completed successfully!");

        } catch (InsufficientFuelException e) {
            throw new MissionDataException("Mission failed due to fuel shortage.", e);

        } catch (NullPointerException e) {
            throw new MissionDataException("Mission failled due to Missing spacecraft or astronout " ,e);
        } catch (RuntimeException e) {
            throw new MissionDataException("Mission failled due to unexpected run time exception",e);
        } finally {
            System.out.println("Mission control finished processing task: " + task.getName());
        }
    }

    // get the text than creates file and write inside it.
    void exportMissionLog(String logText) {
        PrintWriter out = null;
        try {

            out = new PrintWriter(new FileWriter("logs.txt",true));

            out.println(logText);

            System.out.println("Log successfully exported to logs.txt");

        }catch (IOException e){
            System.out.println("I/O error occured. "+ e.getMessage());
        }finally {
            if(out != null){
                out.close();
                System.out.println("File resource celanly closed.");
            }
        }
    }


}
