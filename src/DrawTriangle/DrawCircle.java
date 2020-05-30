package DrawTriangle;


import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author bhanuka
 */
public interface DrawCircle {
    public void setRandomLocation(Circle tPoint, Circle c);
    
    public void updateLines(Line[] lines, Circle[] p, Text[] angles);
}
