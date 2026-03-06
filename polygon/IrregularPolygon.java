package polygon;

import java.awt.geom.*; // for Point2D.Double
import java.util.ArrayList; // for ArrayList
import gpdraw.*; // for DrawingTool

public class IrregularPolygon {
    private ArrayList<Point2D.Double> myPolygon = new ArrayList<Point2D.Double>();

    // constructor
    public IrregularPolygon() {}

    // public methods
    public void add(Point2D.Double aPoint)
    {
        // TODO: Add a point to the IrregularPolygon.
        myPolygon.add(aPoint);
    }

    public double perimeter() {
        // TODO: Calculate the perimeter
        double perimeter = 0.0;
        for(int i = 0; i < myPolygon.size(); i++){
            Point2D.Double p1 = myPolygon.get(i);
            Point2D.Double p2 = myPolygon.get((i + 1) % myPolygon.size());
            double dx = p2.x - p1.x;
            double dy = p2.y - p1.y;
            perimeter += Math.sqrt(dx * dx + dy * dy);
        }
        return perimeter;
    }

    public double area() {
        // TODO: Calculate the area.
        Double area = 0.0;
        for(int i = 0; i < myPolygon.size(); i++){
            Point2D.Double p1 = myPolygon.get(i);
            Point2D.Double p2 = myPolygon.get((i + 1) % myPolygon.size());
            area += (p1.x * p2.y) - (p1.y * p2.x);
        }
        area = Math.abs(area) / 2.0;
        return area;
    }

    public void draw()
    {
        // Wrap the DrawingTool in a try/catch to allow development without need for graphics.
        try {
            // TODO: Draw the polygon.
            // Documents: https://pavao.org/compsci/gpdraw/html/gpdraw/DrawingTool.html
            DrawingTool myDrawingTool = new DrawingTool(new SketchPad(500, 500));
            if(myPolygon.size() == 0) return;

            Point2D.Double first = myPolygon.get(0);
            myDrawingTool.up();
            myDrawingTool.move(first.x, first.y);
            myDrawingTool.down();

            for(int i = 1; i < myPolygon.size(); i++){
                Point2D.Double p = myPolygon.get(i);
                myDrawingTool.move(p.x, p.y);
            }

            myDrawingTool.move(first.x, first.y);
        } catch (java.awt.HeadlessException e) {
            System.out.println("exception: No graphics support available.");
        }
    }

}