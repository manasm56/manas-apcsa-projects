package robot;

import kareltherobot.*;

public class Roomba implements Directions {

    // Main method to make this self-contained
    public static void main(String[] args) {
        // LEAVE THIS ALONE!!!!!!
        String worldName = "robot/basicRoom.wld";
        World.setDelay(1);

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
        
          
        int area=0;
        int moves=0;
        
        int largestPile=0;
        int pileCount=0;
        int noOfBeepersInPile=0;
        int positionx=0;
        int positiony=0;
        // simple position counters
        boolean needToCleanMore = true;
        
        while (needToCleanMore) {
            roomba.move();
            moves++;
            area++;
            
            noOfBeepersInPile=0;
            
            boolean processedPile = false;
            while (roomba.nextToABeeper()) {
                roomba.pickBeeper();
                totalBeepers++;
                noOfBeepersInPile++;
                if(noOfBeepersInPile > largestPile ){
                    largestPile = noOfBeepersInPile;
                    positionx=roomba.avenue();
                    positiony=roomba.street();
                }
                processedPile = true;
            }
            
            if(processedPile) {
                pileCount++;
            }

            while (!roomba.frontIsClear() && roomba.facingEast()) {
                roomba.turnLeft();
                area++;
                moves++;


                if(! roomba.frontIsClear()) {
                    needToCleanMore = false;
                    break;
                }
                roomba.move();
                
                roomba.turnLeft();    
            }

            while (!roomba.frontIsClear() && roomba.facingWest()) {
                roomba.turnLeft();
                roomba.turnLeft();
                roomba.turnLeft();
                area++;
                moves++;

                if(! roomba.frontIsClear()) {
                    needToCleanMore = false;
                    break;
                }

                roomba.move();
                
                roomba.turnLeft();
                roomba.turnLeft();
                roomba.turnLeft();
                /***
                while (!roomba.frontIsClear() && roomba.facingNorth()){
                    roomba.turnOff();
                } 
                ***/
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
        System.out.println("number of moves the roomba did is " + moves + " moves");
        System.out.println("area of room is: " + area + " square units");
        System.out.println("largest pile has: "+ largestPile + " beepers");
        System.out.println( "the coordinates of largest pile is:" + "(" + positionx + "," + positiony + ")" );
        System.out.println("The number of piles is "+ pileCount + " piles" );
        System.out.println("Percent dirty is " + ((double) pileCount * 100/area) + "%"  );
        System.out.println("the average pile size is " + ((double)totalBeepers/pileCount));
        

        return totalBeepers;
        
    }

}