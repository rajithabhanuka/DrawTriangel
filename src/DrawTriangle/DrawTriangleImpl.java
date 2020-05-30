package DrawTriangle;


import javafx.scene.shape.Line;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author bhanuka
 */
public class DrawTriangleImpl implements DrawTriangle{

    @Override
    public double distance(Line line) {
       return distance(line.getStartX(), line.getStartY(), line.getEndX(), line.getEndY());
    }

    @Override
    public double distance(double x1, double y1, double x2, double y2) {
        return Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
    }
    
    
}
