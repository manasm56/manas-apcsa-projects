package robot;

import kareltherobot.*;

public class Roomba implements Directions {

    // Main method to make this self-contained
    public static void main(String[] args) {
        // LEAVE THIS ALONE!!!!!!
        String worldName = "robot/basicRoom.wld";
        World.setDelay(90);

        Roomba cleaner = new Roomba();
        int totalBeepers = cleaner.cleanRoom(worldName, 7, 6);
        System.out.println("Roomba cleaned up a total of " + totalBeepers + " beepers.");
        

    }

    public int cleanRoom(String worldName, int startX, int startY) {
        // Initialize the Robot at the starting position
           Robot roomba = new Robot(startX, startY, East, 0);
        World.readWorld(worldName);
        World.setVisible(true);

        int totalBeepers = 0;

        // Navigate and clean the 5x5 area


        while(roomba.nextToABeeper()){
            roomba.pickBeeper();
        }
        for(int i=1;i<=7;i++){
            roomba.move();
        }
            
        

        return totalBeepers; 
    }
}