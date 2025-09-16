package robot;

import kareltherobot.*;

public class Roomba implements Directions {

    public static void main(String[] args) {
        String worldName = "robot/finalTestWorld2024.wld";
        World.setDelay(0);

        Roomba cleaner = new Roomba();
        int totalBeepers = cleaner.cleanRoom(worldName, 26, 101);
        System.out.println("Roomba cleaned up a total of " + totalBeepers + " beepers.");
    }

    public int cleanRoom(String worldName, int startX, int startY) {
        // load world before creating robot
        World.readWorld(worldName);
        World.setVisible(true);

        Robot roomba = new Robot(startX, startY, East, 0);

        int totalBeepers = 0;
        int area = 0;            
        int moves = 0;           

        int largestPile = 0;
        int pileCount = 0;
        int positionx = 0;
        int positiony = 0;

        while (true) {
            // count this tile as visited
            area++;

            // pick up all beepers on the current square
            int pileHere = 0;
            while (roomba.nextToABeeper()) {
                roomba.pickBeeper();
                totalBeepers++;
                pileHere++;
            }

            if (pileHere > 0) { // checks if we can increase pile count 
                pileCount++;
                if (pileHere > largestPile) { //checks for largest pile 
                    largestPile = pileHere;
                    positionx = roomba.avenue(); // gets x and y values 
                    positiony = roomba.street();
                }
            }

            // if front is clear, step forward
            if (roomba.frontIsClear()) {
                roomba.move();
                
                continue;
            }

            // front blocked: try to move to next row
            if (roomba.facingEast()) {
                roomba.turnLeft();
                if (roomba.frontIsClear()) {
                    roomba.move();
                    
                    roomba.turnLeft();
                    
                } else {
                    break; // finished
                }
            } else if (roomba.facingWest()) {
                roomba.turnLeft();
                roomba.turnLeft();
                roomba.turnLeft();
                if (roomba.frontIsClear()) {
                    roomba.move();
                    
                    roomba.turnLeft();
                    roomba.turnLeft();
                    roomba.turnLeft();
                    
                } else {
                    break; // finished
                }
            } else {
                break; // facing north or south and blocked
            }
        }

        moves=area;
        System.out.println("number of moves the roomba did is " + moves + " moves");
        System.out.println("area of room is: " + area + " square units");
        System.out.println("largest pile has: " + largestPile + " beepers");
        System.out.println("the coordinates of largest pile is: (" + positionx + "," + positiony + ")");
        System.out.println("The number of piles is " + pileCount + " piles");
        System.out.println("Percent dirty is " + ((double) pileCount * 100 / area) + "%");
        System.out.println("the average pile size is " + ((double) totalBeepers / pileCount));
        

        return totalBeepers;
    }
}
