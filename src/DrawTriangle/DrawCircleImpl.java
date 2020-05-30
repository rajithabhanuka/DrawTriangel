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
public class DrawCircleImpl implements DrawCircle {

    @Override
    public void setRandomLocation(Circle tPoint, Circle c) {

        double angle = Math.random() * 360;
        double x = c.getCenterX() + c.getRadius() * Math.cos(Math.toRadians(angle));
        double y = c.getCenterY() + c.getRadius() * Math.sin(Math.toRadians(angle));
        tPoint.setCenterX(x);
        tPoint.setCenterY(y);

    }

    @Override
    public void updateLines(Line[] lines, Circle[] p, Text[] angles) {

        for (int i = 0; i < lines.length; i++) {

            int cIndex2 = (i + 1 >= p.length) ? 0 : i + 1;
            lines[i].setStartX(p[i].getCenterX());
            lines[i].setStartY(p[i].getCenterY());
            lines[i].setEndX(p[cIndex2].getCenterX());
            lines[i].setEndY(p[cIndex2].getCenterY());
            angles[i].setX(p[i].getCenterX() + 5);
            angles[i].setY(p[i].getCenterY() - 5);

        }

        double a = new DrawTriangleImpl().distance(lines[0]);
        double b = new DrawTriangleImpl().distance(lines[1]);
        double c = new DrawTriangleImpl().distance(lines[2]);

        double A = Math.toDegrees(Math.acos((a * a - b * b - c * c) / (-2 * b * c)));
        angles[2].setText(String.format("%.2f 1", A));

        double B = Math.toDegrees(Math.acos((b * b - a * a - c * c) / (-2 * a * c)));
        angles[0].setText(String.format("%.2f 2", B));

        double C = Math.toDegrees(Math.acos((c * c - b * b - a * a) / (-2 * a * b)));
        angles[1].setText(String.format("%.2f 3", C));
    }

}
