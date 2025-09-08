package robot;

import kareltherobot.*;

public class Roomba implements Directions {

    // Main method to make this self-contained
    public static void main(String[] args) {
        // LEAVE THIS ALONE!!!!!!
        String worldName = "robot/basicRoom.wld";
        World.setDelay(10);

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
        int maxBeepers = 0;
        int avenueNo=0,streetNo=0;
       // for (int a=0; a<=4;a++){
        while (roomba.frontIsClear()) {
            roomba.move();
            
            while (roomba.nextToABeeper()) {
                roomba.pickBeeper();
                totalBeepers++;
                if(maxBeepers<totalBeepers){
                    maxBeepers=totalBeepers;
                    totalBeepers=0;
                    
                }
                

            }
            while (!roomba.frontIsClear() && roomba.facingEast()) {
            roomba.turnLeft();
            roomba.move();
            roomba.turnLeft();
        }
        while (!roomba.frontIsClear() && roomba.facingWest()) {
           roomba.turnLeft();
           roomba.turnLeft();
           roomba.turnLeft();
           roomba.move();
           roomba.turnLeft();
           roomba.turnLeft();
           roomba.turnLeft();
        }
        }
        
        
    //}
        // Navigate and clean the 5x5 area

        /*
         * while(roomba.nextToABeeper()){
         * roomba.pickBeeper();
         * }
         * for(int i=1;i<=7;i++){
         * roomba.move();
         * }
         * 
         */

        return totalBeepers;
        
    }
}