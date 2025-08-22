package robot;
import kareltherobot.*;


public class Diamond implements Directions{

    public static void main(String[] args) {

        World.setVisible(true);// allows us to see the run output
        // the bigger the street, the farther north
        World.setSize(20,20);
        World.setDelay(1);

        Robot r = new Robot(5,10,East,90);

        for (int i = 0; i < 6; i++ ) {
            r.turnLeft();
            r.move();
            r.turnLeft();
            r.turnLeft();
            r.turnLeft();
            r.move();
            r.putBeeper();


        }
        r.turnLeft();
        r.move();
        r.turnLeft();
        r.move();
        r.putBeeper();

        for (int t = 0; t < 4; t++ ) {
            
            r.turnLeft();
            r.turnLeft();
            r.turnLeft();
            r.move();
            r.turnLeft();
            r.move();
            r.putBeeper();


        }

        for (int z = 0; z < 5; z++ ) {
            
            r.turnLeft();
            r.move();
            r.turnLeft();
            r.turnLeft();
            r.turnLeft();
            r.move();
            r.putBeeper();


        }

        r.turnLeft();
        r.move();
        r.turnLeft();
        r.move();
        r.putBeeper();

         for (int y = 0; y < 4; y++ ) {
            
            
            r.turnLeft();
            r.turnLeft();
            r.turnLeft();
            r.move();
            r.turnLeft();
            r.move();
            r.putBeeper();


        }
        




        /* 
        Robot rob = new Robot(5,10,East,90);

       
        rob.move();
        rob.turnLeft();
        rob.move();
        rob.putBeeper();
        rob.move();
        rob.turnLeft();
        rob.turnLeft();
        rob.turnLeft();
        rob.move();
        rob.putBeeper();
        rob.move();
        rob.turnLeft();
        
        rob.move();
        rob.putBeeper();
        rob.move();
        rob.turnLeft();
        rob.turnLeft();
        rob.turnLeft();
        rob.move();
        rob.putBeeper();
         rob.move();
        rob.turnLeft();
        
        rob.move();
        rob.putBeeper();
        rob.move();
        rob.turnLeft();
        rob.turnLeft();
        rob.turnLeft();
        rob.move();
        rob.putBeeper();
        rob.turnLeft();
        rob.move();
        rob.turnLeft();
        rob.move();
        rob.putBeeper();
        rob.move();
        rob.turnLeft();
        rob.turnLeft();
        rob.turnLeft();
        rob.move();
        rob.putBeeper();
        rob.move();
        rob.turnLeft();
        rob.move();
        rob.putBeeper();
        rob.move();
        rob.turnLeft();
        rob.turnLeft();
        rob.turnLeft();
        rob.move();
        rob.putBeeper();
         rob.move();
        rob.turnLeft();
        rob.move();
        rob.putBeeper();
        rob.move();
        rob.turnLeft();
        rob.move();
        rob.putBeeper();
        rob.move();
        rob.turnLeft();
        rob.turnLeft();
        rob.turnLeft();
        rob.move();
        rob.putBeeper();
        rob.move();
        rob.turnLeft();
        rob.move();
        rob.putBeeper();
        rob.move();
        rob.turnLeft();
        rob.turnLeft();
        rob.turnLeft();
        rob.move();
        rob.putBeeper();
        rob.move();
        rob.turnLeft();
        rob.move();
        rob.putBeeper();
        rob.move();
        rob.turnLeft();
        rob.move();
        rob.putBeeper();
        rob.move();
        rob.turnLeft();
        rob.turnLeft();
        rob.turnLeft();
        rob.move();
        rob.putBeeper();
        rob.move();
        rob.turnLeft();
        rob.move();
        rob.putBeeper();
        rob.move();
        rob.turnLeft();
        rob.turnLeft();
        rob.turnLeft();
        rob.move();
        rob.putBeeper();
        rob.move();
        rob.move();
        rob.move(); 
        */


        

        
        




        // done with the line, now on the curve
        // rob.turnLeft();

    }
}
