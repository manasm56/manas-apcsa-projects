package robot;

import kareltherobot.*;

public class Roomba implements Directions {

    // Main method to make this self-contained
    public static void main(String[] args) {
        // LEAVE THIS ALONE!!!!!!
        String worldName = "robot/basicRoom.wld";
        World.setDelay(5);

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
        int positionx=0;
        int positiony=0;
        // simple position counters
        boolean needClean=true;

       while(true){
        
        while (roomba.frontIsClear()) {
            roomba.move();
            moves++;
            area++;
            
            pileCount=0;
            
            
            while (roomba.nextToABeeper()) {
                roomba.pickBeeper();
                totalBeepers++;
                pileCount++;
                if(pileCount > largestPile ){
                    largestPile = pileCount;
                   positionx=roomba.street();
                   positiony=roomba.avenue();
                }
               

                
              


                

            }
            
                
            
            while (!roomba.frontIsClear() && roomba.facingEast()) {
            roomba.turnLeft();
            roomba.move();
            moves++;
            area++;
            roomba.turnLeft();
            
        }
        while (!roomba.frontIsClear() && roomba.facingWest()) {
           roomba.turnLeft();
           roomba.turnLeft();
           roomba.turnLeft();
           roomba.move();
           moves++;
           area++;
           roomba.turnLeft();
           roomba.turnLeft();
           roomba.turnLeft();
           while (!roomba.frontIsClear() && roomba.facingNorth()){
            roomba.turnOff();

           }
           
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
        System.out.println("number of moves the roomba did is " + moves);
        System.out.println("area of room is: " + area);
        System.out.println("largest pile is: "+ largestPile);
        System.out.println( "the coordinates of largest pile is:" + "(" + positionx + "," + positiony + ")" );
        
        


        return totalBeepers;
        
    }
}

}