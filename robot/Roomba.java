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
           
            area++;

            
            int pileHere = 0;
            while (roomba.nextToABeeper()) {
                roomba.pickBeeper();
                totalBeepers++;
                pileHere++;
            }

            if (pileHere > 0) {
                pileCount++;
                if (pileHere > largestPile) {
                    largestPile = pileHere;
                    positionx = roomba.avenue();
                    positiony = roomba.street();
                }
            }

            
            if (roomba.frontIsClear()) {
                roomba.move();

                continue;
            }

            
            if (roomba.facingEast()) {
                roomba.turnLeft();
                if (roomba.frontIsClear()) {
                    roomba.move();

                    roomba.turnLeft();
                    continue;
                } else {
                    break; 
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
                    continue;
                } else {
                    break;
                }
            } else {
                break; 
            }
        }

        moves = area;
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
