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
public interface DrawTriangle {

    public double distance(Line line);

    public double distance(double x1, double y1, double x2, double y2);
}
